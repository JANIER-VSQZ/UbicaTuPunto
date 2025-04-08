package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import android.widget.Toast;/*Aqui arriba no se si he importado lo necesario, chequen por si acaso*/

public class Profile extends AppCompatActivity {
    TextView txtNombre, txtCorreo, txtGenero;
    String correoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNombre = findViewById(R.id.txtNombreUsuario);
        txtCorreo = findViewById(R.id.txtCorreoUsuario);
        txtGenero = findViewById(R.id.txtGeneroUsuario);

        // Recibir el correo que se envió por Intent
        correoUsuario = getIntent().getStringExtra("correo_usuario");

        if (correoUsuario != null) {
            cargarDatosUsuario(correoUsuario);
        } else {
            Toast.makeText(this, "Error: no se recibió el correo del usuario", Toast.LENGTH_SHORT).show();
        }
    }

    private void cargarDatosUsuario(String correo) {
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "UbicaTuPunto", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor fila = db.rawQuery("SELECT nombre, correo, id_sexo FROM Users WHERE correo = ?", new String[]{correo});

        if (fila.moveToFirst()) {
            String nombre = fila.getString(0);
            String correoUsuario = fila.getString(1);
            int idGenero = fila.getInt(2);
            String generoTexto;

            switch (idGenero) {
                case 1:
                    generoTexto = "Masculino";
                    break;
                case 2:
                    generoTexto = "Femenino";
                    break;
                default:
                    generoTexto = "Otro";
                    break;
            }

            txtNombre.setText(nombre);
            txtCorreo.setText(correoUsuario);
            txtGenero.setText(generoTexto);
        } else {
            Toast.makeText(this, "No se encontraron datos del usuario", Toast.LENGTH_SHORT).show();
        }
        fila.close();
        db.close();
    }


    //METODO DEL BOTON MENU
    public void Menu(View view){
        Intent menu = new Intent(this, Selection.class);
        menu.putExtra("correo_usuario", correoUsuario); // vuelve a mandar el correo
        startActivity(menu);
    } //FIN METODO DEL BOTON MENU


    //METODO DEL BOTON MISION
    public void Mision(View view){
        Intent mision = new Intent(this, Mision.class);
        mision.putExtra("correo_usuario", correoUsuario);
        startActivity(mision);
    } //FIN METODO DEL BOTON MENU


    //METODO DEL BOTON CAMBIAR CONTRASEÑA
    public void Contra(View view){
        Intent contra = new Intent(this,ChangePassword.class);
        startActivity(contra);
    } //FIN METODO DEL BOTON CAMBIAR CONTRASEÑA

    //METODO CAMBIAR CUENTA
    public void CambiarUsuario(View view){
        Intent cambiousuario = new Intent(this,MainActivity.class);
        startActivity(cambiousuario );
    } //FIN METODO CAMBIAR CUENTA
}