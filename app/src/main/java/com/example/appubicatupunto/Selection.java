package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Selection extends AppCompatActivity {
int selectedOption = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imgTaxi = findViewById(R.id.btnTaxi);
        ImageView imgBus = findViewById(R.id.btnBus);
        Button btnDetalles = findViewById(R.id.btnDetalles);
        Button btnImagen= findViewById(R.id.btnImagen);

        imgBus.setOnClickListener(v -> {
            selectedOption = 1;
            imgBus.setAlpha(1.0f);
            imgTaxi.setAlpha(0.5f); // Reduce la opacidad del otro
        });
        imgTaxi.setOnClickListener(v -> {
            selectedOption = 2;
            imgTaxi.setAlpha(1.0f);
            imgBus.setAlpha(0.5f); // Reduce la opacidad del otro
        });

        btnImagen.setOnClickListener(v->{
            if (selectedOption==1){
                Intent TBus = new Intent(this, GaleryViewBus.class);
                startActivity(TBus);
            } else if (selectedOption==2) {
                Intent Ttaxi = new Intent(this, GaleryViewTaxis.class);
                startActivity(Ttaxi);
            }
        });

        btnDetalles.setOnClickListener(v->{
            if (selectedOption==1){
                Intent TBus = new Intent(this, MapViewBus.class);
                startActivity(TBus);
            } else if (selectedOption==2) {
                Intent Ttaxi = new Intent(this, MapViewTaxis.class);
                startActivity(Ttaxi);
            }
        });
    }



    //METODO DEL BOTON PERFIL
    public void perfil(View view){
        Intent perfil = new Intent(this,Profile.class);
        startActivity(perfil);
    } //FIN METODO DEL PERFIL


    //METODO DEL BOTON INFORMACION APP
    public void info(View view){
        Intent info = new Intent(this,Mision.class);
        startActivity(info);
    } //FIN METODO DEL BOTON INFORMACION APP
}