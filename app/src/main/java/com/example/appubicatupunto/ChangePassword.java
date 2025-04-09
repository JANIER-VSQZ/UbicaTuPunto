package com.example.appubicatupunto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChangePassword extends AppCompatActivity {
    private String correoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        correoUsuario = getIntent().getStringExtra("correo_usuario");

        if (correoUsuario == null) {
            Toast.makeText(this, "No se recibió el correo del usuario", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //METODO CAMBIAR CONTRASEÑA/LOGIN
    public void cambiarContrasena(View view) {

        EditText nuevaContrasenaEditText = findViewById(R.id.txtRecuperarContra);
        String nuevaClave = nuevaContrasenaEditText.getText().toString();

        if (nuevaClave.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa la nueva contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if (correoUsuario == null || correoUsuario.isEmpty()) {
            Toast.makeText(this, "No se recibió el correo del usuario", Toast.LENGTH_SHORT).show();
            return;
        }

        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "UbicaTuPunto", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("clave", nuevaClave);

        int cantidad = BaseDeDatos.update("Users", valores, "correo = ?", new String[]{correoUsuario});

        BaseDeDatos.close();

        if (cantidad == 1) {
            Toast.makeText(this, "Contraseña actualizada correctamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "No se pudo actualizar la contraseña", Toast.LENGTH_LONG).show();
        }
    }//FIN DEL METODO CAMBIAR CONTRASEÑA/LOGIN

}