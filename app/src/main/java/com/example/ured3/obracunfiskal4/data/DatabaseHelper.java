package com.example.ured3.obracunfiskal4.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ured3.obracunfiskal4.Artikli;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    public static final String DATABASE_NAME = "artiklii.db";
    public static final String TABLE_NAME = "Artiklii";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAZIV";
    public static final String COL3 = "CIJENA";
    public static final String COL4 = "POREZ";
    public static final String COL5 = "ZALIHA";
    public static final String COL6 = "DONOS";
    public static final String COL7 = "UKUPNO";
    public static final String COL8 = "OSTATAK";
    public static  final String COL9 = "PRODANO";
    public static final String COL10 = "IZNOS";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAZIV TEXT, CIJENA DOUBLE, POREZ DOUBLE, ZALIHA DOUBLE, DONOS DOUBLE, UKUPNO DOUBLE,OSTATAK DOUBLE, PRODANO DOUBLE, IZNOS DOUBLE)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String NazivA, String CijenaA,String PorezA, String ZalihaA, String DonosA,String UkupnoA, String OstatakA, String ProdanoA, String IznosA) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, NazivA);
        contentValues.put(COL3, CijenaA);
        contentValues.put(COL4, PorezA);
        contentValues.put(COL5, ZalihaA);
        contentValues.put(COL6, DonosA);
        contentValues.put(COL7, UkupnoA);
        contentValues.put(COL8, OstatakA);
        contentValues.put(COL9, ProdanoA);
        contentValues.put(COL10, IznosA);


        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
    public List<Artikli> getAllArtikli(String sSQL) {
        List<Artikli> artikliList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sSQL, null);


        if (cursor.moveToFirst()) {
            do {
                Artikli artikal = new Artikli();
                artikal.setNazivA(cursor.getString(1));
                artikal.setCijenaA(cursor.getDouble(2));
                artikal.setPoreza(cursor.getDouble(3));
                artikal.setZalihaA(cursor.getDouble(4));
                artikal.setDonosA(cursor.getDouble(5));
                artikal.setOstatakA(cursor.getDouble(6));
                artikal.setUkupnoA(cursor.getDouble(7));
                artikal.setProdanoA(cursor.getDouble(8));
                artikal.setIznos(cursor.getDouble(9));



                artikliList.add(artikal);
            } while (cursor.moveToNext());
        }
        db.close();
        return artikliList;
}}