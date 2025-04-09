package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class Selection extends AppCompatActivity {
int selectedOption = 0;
private Spinner cbCiudad;

private TextView txtRuta;
private TextView txtDestino;

private TextView txtRuta2;
private TextView txtDestino2;
    String correoUsuario;
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
        correoUsuario = getIntent().getStringExtra("correo_usuario");

        ImageView imgTaxi = findViewById(R.id.btnTaxi);
        ImageView imgBus = findViewById(R.id.btnBus);
        Button btnDetalles = findViewById(R.id.btnDetalles);
        Button btnImagen= findViewById(R.id.btnImagen);
        Button btnDetalles2 = findViewById(R.id.btnDetalles2);
        Button btnImagen2= findViewById(R.id.btnImagen2);
        cbCiudad = (Spinner) findViewById(R.id.cbCiudad);
        ScrollView scvPrincipal = findViewById(R.id.scvContenido);
        TextView txtAdvertencia = findViewById(R.id.txtAdvertencia);
        txtRuta = (TextView) findViewById(R.id.txtNombreRuta);
        txtDestino=(TextView) findViewById(R.id.txtDestinoRuta);
        txtRuta2 = (TextView) findViewById(R.id.txtNombreRuta2);
        txtDestino2=(TextView) findViewById(R.id.txtDestinoRuta2);

        agregarCB();

        imgBus.setOnClickListener(v -> {
            selectedOption = 1;
            imgBus.setAlpha(1.0f);
            imgTaxi.setAlpha(0.5f); // Reduce la opacidad del otro
            scvPrincipal.setVisibility(View.VISIBLE);
            txtAdvertencia.setVisibility(View.INVISIBLE);
            txtRuta.setText("Puntos de Buses:");
            txtDestino.setText("FID-110\nFID-162\nFID-163\nFID-111\nFID-161\nFID-246\nFID-109\nFID-108\nFID-247\nFID-112");
            txtRuta2.setText("Puntos de Buses:");
            txtDestino2.setText("FID-160\nFID-113\nFID-114\nFID-159\nFID-247\nFID-232\nFID-231\nFID-235\nFID-236\nFID-230");
        });
        imgTaxi.setOnClickListener(v -> {
            selectedOption = 2;
            imgTaxi.setAlpha(1.0f);
            imgBus.setAlpha(0.5f); // Reduce la opacidad del otro
            scvPrincipal.setVisibility(View.VISIBLE);
            txtAdvertencia.setVisibility(View.INVISIBLE);
            txtRuta.setText("Puntos de Taxis:");
            txtDestino.setText("UNAH\nHato Centro\nPlaza Miraflores\nLlanos-Emisoras\nLas Palmas\nRes Honduras");
            txtRuta2.setText("Puntos de Taxis:");
            txtDestino2.setText("Carrizal\nCerro Grande\nLa Granja\nLa San Miguel\nKennedy\nEl Sitio\nla Flor del Campo");
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

        btnImagen2.setOnClickListener(v->{
            if (selectedOption==1){
                Intent TBus = new Intent(this, GaleryViewBus.class);
                startActivity(TBus);
            } else if (selectedOption==2) {
                Intent Ttaxi = new Intent(this, GaleryViewTaxis.class);
                startActivity(Ttaxi);
            }
        });

        btnDetalles2.setOnClickListener(v->{
            if (selectedOption==1){
                Intent TBus = new Intent(this, MapViewBus2.class);
                startActivity(TBus);
            } else if (selectedOption==2) {
                Intent Ttaxi = new Intent(this, MapViewTaxi2.class);
                startActivity(Ttaxi);
            }
        });
    }





    public void agregarCB(){
        ArrayList<String> datosCB = new ArrayList<>();
        datosCB.add("Tegucigalpa");
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datosCB);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Vincular adaptador al spinner
        cbCiudad.setAdapter(adaptador);
    }



    //METODO DEL BOTON PERFIL
    public void perfil(View view){
        Intent perfil = new Intent(this, Profile.class);
        perfil.putExtra("correo_usuario", correoUsuario); // pasamos el correo
        startActivity(perfil);
    } //FIN METODO DEL PERFIL


    //METODO DEL BOTON INFORMACION APP
    public void info(View view){
        Intent mision = new Intent(this, Mision.class);
        mision.putExtra("correo_usuario", correoUsuario);
        startActivity(mision);
    } //FIN METODO DEL BOTON INFORMACION APP
}