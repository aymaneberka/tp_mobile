package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Produit {
    DBConnect cn;
    //constructeur
    public Produit(Context context) {
        cn=new DBConnect(context);
    }
    //insertion
    public void insertdt(int code, String descp, String prix){
        SQLiteDatabase db=cn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("_id",code);
        values.put("description",descp);
        values.put("prix",prix);
        db.insert("produit",null,values);


    }

    public void delete(Integer code){
        SQLiteDatabase db=cn.getWritableDatabase();
        String[] s=new String[]{String.valueOf(code)};
        db.delete("produit","_id=?",s);
    }

    public void update(Integer code,String descp,String prix){
        SQLiteDatabase db=cn.getWritableDatabase();
        ContentValues contentValue=new ContentValues();


        contentValue.put("description",descp);
        contentValue.put("prix",prix);

        String[] rsl=new String[]{String.valueOf(code)};

        db.update("produit", contentValue, "_id=?", rsl);
    }
    public Cursor data(){
        SQLiteDatabase db=cn.getReadableDatabase();
        return db.rawQuery("select * from produit",null);}
}

