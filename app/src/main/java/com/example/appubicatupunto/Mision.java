package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Mision extends AppCompatActivity {
    private String correoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mision);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        correoUsuario = getIntent().getStringExtra("correo_usuario");

        if (correoUsuario == null) {
            Toast.makeText(this, "No se recibió el correo del usuario", Toast.LENGTH_SHORT).show();
            finish(); // o manejarlo de otra forma
        }
    }
    //METODO DEL BOTON PERFIL
    public void perfil(View view){
        Intent perfil = new Intent(this, Profile.class);
        perfil.putExtra("correo_usuario", correoUsuario);
        startActivity(perfil);
    } //FIN METODO DEL PERFIL

    //METODO DEL BOTON SELECCION
    public void seleccion(View view){
        Intent seleccion = new Intent(this, Selection.class);
        seleccion.putExtra("correo_usuario", correoUsuario);
        startActivity(seleccion);
    } //FIN METODO DEL SELECCION



}