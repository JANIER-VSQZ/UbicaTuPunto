package com.example.appubicatupunto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;

public class CreateUser extends AppCompatActivity {

    EditText txtcorreo;
    EditText txtnombre;
    EditText txtclave;
    //RadioGroup radioGroup   = findViewById(R.id.RGIdSexo);
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtcorreo   = (EditText)findViewById(R.id.txtCreateUserEmail);
        txtnombre   = (EditText)findViewById(R.id.txtCreateUserNombre);
        txtclave    = (EditText)findViewById(R.id.txtCreateUserClave);
        radioGroup  = findViewById(R.id.rgSexo);
    }


    //metodo Buscar
    public boolean Buscar(){
        boolean vrReturn = false;

        AdminSQLiteOpen admin  = new AdminSQLiteOpen(this,"UbicaTuPunto",null,1); // objeto clase del adminsqlite

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase(); // base de datos modo escritura

        String codigo = txtcorreo.getText().toString(); //obtenemos  codigo ingresado en el teclado

        if(!codigo.isEmpty()){
            //Cursor fila = BaseDeDatos.rawQuery("select correo from Users where correo ="+ codigo,null);
            Cursor fila = BaseDeDatos.rawQuery("select correo from Users where correo = ?", new String[] { codigo });
            if(fila.moveToFirst()){
                Toast.makeText(this,"El correo que ingresó, ya existe",Toast.LENGTH_SHORT).show();
                vrReturn = true;
            }
            else {
                vrReturn = false;
            }
        }else{
            Toast.makeText(this,"Por favor ingrese el correo",Toast.LENGTH_SHORT).show();

            vrReturn = false;
        }
        return vrReturn;
    } // fin metodo buscar

    public  void ingresar(View view){
        boolean vrEncontrado;

        vrEncontrado = Buscar();

        if (vrEncontrado == false) {
            AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "UbicaTuPunto", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            Integer vr = 0;

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();
                vr = radioGroup.indexOfChild(selectedRadioButton) + 1;

                //Toast.makeText(this, "Selected: " + vr, Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
            }

            if (!txtcorreo.getText().toString().isEmpty() && !txtnombre.getText().toString().isEmpty() && !txtclave.getText().toString().isEmpty()) {

                ContentValues registro = new ContentValues(); //registar los datos

                registro.put("correo", txtcorreo.getText().toString());
                registro.put("id_sexo", vr);
                registro.put("nombre", txtnombre.getText().toString());
                registro.put("clave", txtclave.getText().toString());

                Toast.makeText(this, "El usuario ha sido guardado de forma existosa", Toast.LENGTH_SHORT).show();
                BaseDeDatos.insert("Users", null, registro);
                BaseDeDatos.close();

                txtcorreo.setText("");
                txtnombre.setText("");
                txtclave.setText("");
            } else {

                Toast.makeText(this, "Todos los campos deben llenarse", Toast.LENGTH_SHORT).show();

            }
        }
    }

    //METODO DEL BOTON INICIAR
    public void Iniciar(View view){
        Intent inicio = new Intent(this,MainActivity.class);
        startActivity(inicio);
    } //FIN METODO DEL BOTON INICIAR

}