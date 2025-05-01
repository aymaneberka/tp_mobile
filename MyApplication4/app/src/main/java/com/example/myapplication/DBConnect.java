package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnect extends SQLiteOpenHelper {
    public DBConnect(@Nullable Context context) {
        super(context, "GestionProduit", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//création de la table
        db.execSQL("create table produit(_id integer primary key,description varchar(25),prix varchar(25))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table produit");
        onCreate(db);
    }
}
