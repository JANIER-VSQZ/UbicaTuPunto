package com.example.appubicatupunto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
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

public class MapViewTaxis extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Inicializar MapView
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
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

        // Agregar marcadores con las coordenadas y títulos correspondientes
        LatLng pointUNAH = new LatLng(14.084542638772412, -87.1667253629287);
        mMap.addMarker(new MarkerOptions().position(pointUNAH).title("Punto de taxis UNAH"));

        LatLng pointHatoCentro = new LatLng(14.07655032646491, -87.1679302635903);
        mMap.addMarker(new MarkerOptions().position(pointHatoCentro).title("Punto de taxis Hato Centro"));

        LatLng pointResHonduras = new LatLng(14.054694347816929, -87.17562518004132);
        mMap.addMarker(new MarkerOptions().position(pointResHonduras).title("Punto de taxis Res Honduras"));

        LatLng pointPlazaMiraflores = new LatLng(14.078174334805535, -87.18557810971839);
        mMap.addMarker(new MarkerOptions().position(pointPlazaMiraflores).title("Punto de taxis Plaza Miraflores"));

        LatLng pointLasPalmas = new LatLng(14.061856347423612, -87.18437888258215);
        mMap.addMarker(new MarkerOptions().position(pointLasPalmas).title("Punto de taxis Las Palmas"));

        LatLng pointLlanosEmisoras = new LatLng(14.060691764736113, -87.18987210486127);
        mMap.addMarker(new MarkerOptions().position(pointLlanosEmisoras).title("Punto de taxis Llanos - Emisoras"));

        // Posicionar la cámara en uno de los puntos o en el centro de la zona
        // Aquí se posiciona en el punto de taxis UNAH con un nivel de zoom de 16.0f:
        float zoomLevel = 16.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pointUNAH, zoomLevel));
    }





}