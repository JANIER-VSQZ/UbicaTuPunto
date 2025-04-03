package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Mision extends AppCompatActivity {

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
    }
    //METODO DEL BOTON PERFIL
    public void perfil(View view){
        Intent perfil = new Intent(this,Profile.class);
        startActivity(perfil);
    } //FIN METODO DEL PERFIL

    //METODO DEL BOTON SELECCION
    public void seleccion(View view){
        Intent seleccion = new Intent(this,Selection.class);
        startActivity(seleccion);
    } //FIN METODO DEL SELECCION

}