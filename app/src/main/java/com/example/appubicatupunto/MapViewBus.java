package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapViewBus extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view_bus);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar MapView
        mapView = findViewById(R.id.mapView4);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);  // Obtener el mapa cuando esté listo
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapView != null) {
            mapView.onDestroy();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregar un marcador en Sydney y mover la cámara
        LatLng X; // = new LatLng(-34, 151);
        X = new LatLng(14.05361, -87.253942);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 110"));

        X = new LatLng(14.054129, -87.253906);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 162"));

        X = new LatLng(14.054323, -87.253498);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 163"));

        X = new LatLng(14.050795, -87.254412);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 111"));

        X = new LatLng(14.050749, -87.254047);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 161"));

        X = new LatLng(14.057564, -87.25201);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 246"));

        X = new LatLng(14.060237, -87.25567);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 109"));

        X = new LatLng(14.067771, -87.250647);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 108"));

        X = new LatLng(14.058993, -87.229521);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 247"));

        X = new LatLng(14.043343, -87.238973);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 112"));

        X = new LatLng(14.042732, -87.236632);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 160"));

        X = new LatLng(14.041703, -87.235368);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 113"));

        X = new LatLng(14.040678, -87.230546);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 114"));

        X = new LatLng(14.04141, -87.230309);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 159"));

        X = new LatLng(14.058993, -87.229521);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 247"));

        X = new LatLng(14.054489, -87.222055);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 232"));

        X = new LatLng(14.058816, -87.22069);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 231"));

        X = new LatLng(14.059224, -87.220159);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 235"));

        X = new LatLng(14.063184, -87.219091);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 236"));

        X = new LatLng(14.06396, -87.21921);
        mMap.addMarker(new MarkerOptions().position(X).title("FID - 230"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(X));
        // Mover la cámara y establecer el zoom
        float zoomLevel = 16.0f;  // Aumenta el valor para más zoom (máximo 21.0f)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(X, zoomLevel));
    }
    //METODOS BOTONES DE NAVEGACION
    //METODO DEL BOTON MENU
    public void Menu(View view){
        Intent menu = new Intent(this,Selection.class);
        startActivity(menu);
    } //FIN METODO DEL BOTON MENU


    //METODO DEL BOTON MISION
    public void Mision(View view){
        Intent mision = new Intent(this,Mision.class);
        startActivity(mision);
    } //FIN METODO DEL BOTON MENU

    //METODO DEL BOTON PERFIL
    public void perfil(View view){
        Intent perfil = new Intent(this,Profile.class);
        startActivity(perfil);
    } //FIN METODO DEL PERFIL

}
