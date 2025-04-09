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

        LatLng pointKennedy = new LatLng(14.107802811096871, -87.20290797633483);
        mMap.addMarker(new MarkerOptions().position(pointKennedy).title("Punto de taxis Kennedy"));

        LatLng pointCerroGrande = new LatLng(14.117634214640562, -87.22660348717216);
        mMap.addMarker(new MarkerOptions().position(pointCerroGrande).title("Punto de taxis Cerro Grande"));

        LatLng pointCarrizal = new LatLng(14.094327384173779, -87.23776425763758);
        mMap.addMarker(new MarkerOptions().position(pointCarrizal).title("Punto de taxis Carrizal"));

        LatLng pointResHonduras = new LatLng(14.054694347816929, -87.17562518004132);
        mMap.addMarker(new MarkerOptions().position(pointResHonduras).title("Punto de taxis Res Honduras"));

        LatLng pointPlazaMiraflores = new LatLng(14.078174334805535, -87.18557810971839);
        mMap.addMarker(new MarkerOptions().position(pointPlazaMiraflores).title("Punto de taxis Plaza Miraflores"));

        LatLng pointLasPalmas = new LatLng(14.061856347423612, -87.18437888258215);
        mMap.addMarker(new MarkerOptions().position(pointLasPalmas).title("Punto de taxis Las Palmas"));

        LatLng pointLaSanMiguel = new LatLng(14.109479484257387, -87.20463009453643);
        mMap.addMarker(new MarkerOptions().position(pointLaSanMiguel).title("Punto de taxis La San Miguel"));

        LatLng pointElSitioCentro = new LatLng(14.107480666020596, -87.19535923640245);
        mMap.addMarker(new MarkerOptions().position(pointElSitioCentro).title("Punto de taxis El Sitio - Centro"));

        LatLng pointLaGranja = new LatLng(14.083505090537884, -87.20926742605809);
        mMap.addMarker(new MarkerOptions().position(pointLaGranja).title("Punto La Granja"));

        LatLng pointFlorDelCampo = new LatLng(14.106648968644075, -87.20669058081815);
        mMap.addMarker(new MarkerOptions().position(pointFlorDelCampo).title("Punto de taxis Flor del Campo"));

        LatLng pointLlanosEmisoras = new LatLng(14.060691764736113, -87.18987210486127);
        mMap.addMarker(new MarkerOptions().position(pointLlanosEmisoras).title("Punto de taxis Llanos - Emisoras"));

        // Posicionar la cámara en uno de los puntos o en el centro de la zona
        // Aquí se posiciona en el punto de taxis UNAH con un nivel de zoom de 16.0f:
        float zoomLevel = 16.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pointUNAH, zoomLevel));
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