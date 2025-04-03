package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GaleryViewTaxis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_galery_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //botones de barra de navegacion
    public void Menu(View view){
        Intent menu = new Intent(this,Selection.class);
        startActivity(menu);
    }

    public void Mision(View view) {
        Intent mision = new Intent(this, Mision.class);
        startActivity(mision);
    }

    public void Perfil(View view) {
        Intent perfil = new Intent(this, Profile.class);
        startActivity(perfil);
    }
}