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
        Intent contra = new Intent(this,ChangePassword.class);
        startActivity(contra);
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
        }else {
            Intent login = new Intent(this,Selection.class);
            startActivity(login);
        }
     //FIN METODO PARA INICIAR SESION
    }

}