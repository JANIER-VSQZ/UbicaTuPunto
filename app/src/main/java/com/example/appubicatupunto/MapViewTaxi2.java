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

public class MapViewTaxi2 extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_view_taxi2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mapView = findViewById(R.id.mapView3);
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
        LatLng pointKennedy = new LatLng(14.107802811096871, -87.20290797633483);
        mMap.addMarker(new MarkerOptions().position(pointKennedy).title("Punto de taxis Kennedy"));

        LatLng pointCerroGrande = new LatLng(14.117634214640562, -87.22660348717216);
        mMap.addMarker(new MarkerOptions().position(pointCerroGrande).title("Punto de taxis Cerro Grande"));

        LatLng pointCarrizal = new LatLng(14.094327384173779, -87.23776425763758);
        mMap.addMarker(new MarkerOptions().position(pointCarrizal).title("Punto de taxis Carrizal"));

        LatLng pointLaSanMiguel = new LatLng(14.109479484257387, -87.20463009453643);
        mMap.addMarker(new MarkerOptions().position(pointLaSanMiguel).title("Punto de taxis La San Miguel"));

        LatLng pointElSitioCentro = new LatLng(14.107480666020596, -87.19535923640245);
        mMap.addMarker(new MarkerOptions().position(pointElSitioCentro).title("Punto de taxis El Sitio - Centro"));

        LatLng pointLaGranja = new LatLng(14.083505090537884, -87.20926742605809);
        mMap.addMarker(new MarkerOptions().position(pointLaGranja).title("Punto La Granja"));

        LatLng pointFlorDelCampo = new LatLng(14.106648968644075, -87.20669058081815);
        mMap.addMarker(new MarkerOptions().position(pointFlorDelCampo).title("Punto de taxis Flor del Campo"));

        // Mover la cámara y establecer el zoom
        float zoomLevel = 16.0f;  // Aumenta el valor para más zoom (máximo 21.0f)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pointLaSanMiguel, zoomLevel));
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}