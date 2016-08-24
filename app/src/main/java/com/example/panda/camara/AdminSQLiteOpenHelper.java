package com.example.panda.camara;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ciudades(lugar text primary key,ciudad text, ranking real,comentario text)");
        //db2.execSQL("create table indicadores(ciudad1 int primary key,ciudad2 int, ciudad3 int, ciudad4)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}