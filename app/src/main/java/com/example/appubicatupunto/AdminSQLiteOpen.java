package com.example.appubicatupunto;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AdminSQLiteOpen extends SQLiteOpenHelper {

    //Constructor
    public AdminSQLiteOpen(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //metodo Oncreate
    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL(
                "create table Users" +
                        "(" +
                        "correo String primary key, " +
                        "id_sexo int, " +
                        "nombre String, " +
                        "clave String " +
                        ")");
    }

    //metodo Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int oldVersion, int newVersion) {

    }

}
