package com.example.wannacry.firstdatabase.sqlite;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteOpenHelperR extends SQLiteOpenHelper {

    Activity context;
    static String DATABASE_NAME = "dsc";
    static int DATABASE_VERSION = 1;
    String CREATE_TB_MAHASISWA = "CREATE TABLE tb_mahasiswa(id integer primary key autoincrement, nama text, asal text)";

    public SQLiteOpenHelperR(Activity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TB_MAHASISWA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
