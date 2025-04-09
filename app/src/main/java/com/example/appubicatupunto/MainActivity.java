package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends AppCompatActivity {

    private EditText campocorreo, campocontrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        campocorreo = findViewById(R.id.editTextTextEmailAddress);
        campocontrasena = findViewById(R.id.editTextTextPassword);
    }

    //METODO DEL BOTON CAMBIAR CONTRASEÑA
    public void Contra(View view){
        String correo = campocorreo.getText().toString().trim();

        if (correo.isEmpty()) {
            Toast.makeText(this, "Ingresa tu correo para cambiar la contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "UbicaTuPunto", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE correo = ?", new String[]{correo});

        if (cursor.moveToFirst()) {
            // Si El correo existe, abrir la pantalla de cambio de contraseña
            Intent contra = new Intent(this, ChangePassword.class);
            contra.putExtra("correo_usuario", correo); // pasar el correo para usarlo en la siguiente actividad si se requiere
            startActivity(contra);
        } else {
            // El correo no existe entonces mostrar un mensaje
            Toast.makeText(this, "El correo no está registrado", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        db.close();
    } //FIN METODO DEL BOTON CAMBIAR CONTRASEÑA

    //METODO DEL ENLACE PARA CREAR USUARIO
    public void crearusuario(View view){
        Intent crearusuario = new Intent(this,CreateUser.class);
        startActivity(crearusuario);
    } //FIN METODO PARA CREAR USUARIO

    //METODO PARA INICIAR SESION
    public void login(View view) {
        String correo = campocorreo.getText().toString().trim();
        String contrasena = campocontrasena.getText().toString().trim();

        if (correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa tu correo y contraseña", Toast.LENGTH_SHORT).show();
        } else {
            AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "UbicaTuPunto", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE correo = ? AND clave = ?", new String[]{correo, contrasena});

            if (cursor.moveToFirst()) {
                // Usuario autenticado correctamente
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(this, Selection.class);
                login.putExtra("correo_usuario", correo); // pasar el correo del usuario
                startActivity(login);
            } else {
                // Usuario no encontrado
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            db.close();
        }
    }//FIN DEL METODO PARA INICIAR SESION


}