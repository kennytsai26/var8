package com.example.musicapp.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by B7 on 2015/11/7.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "m4.db";

    public static final int VERSION = 1;

    private static SQLiteDatabase database;

    public static final String TABLE_NAME_GUITAR="guitar";
    public static final String TABLE_NAME_DRUM="drum";
    public static final String TABLE_NAME_PIANO="piano";
    public static final String TABLE_NAME_ELECTROPOP="electropop";
    public static final String TABLE_NAME_VOCAL="vocal";
    public static final String TABLE_NAME_INPUTMUSIC="inputmusic";
    public static final String TABLE_NAME_Recordmusic="recordmusic";
    public static final String id_cloumn="_id";
    public static final String no_cloumn="no";
    public static final String name_cloumn="name";
    public static final String path_cloumn="path";
    public static final String frg_cloumn="fragement";
    public static final String buttonnume_cloumn="buttonname";
    public static final String Guitar_Table_SQL ="CREATE TABLE "+TABLE_NAME_GUITAR+"  ( "
            + id_cloumn + " INTEGER PRIMARY KEY ,"
            + name_cloumn+" TEXT,"
            + path_cloumn+ " Integer "
            + ");";
    public static final String Drum_Table_SQL ="create table "+TABLE_NAME_DRUM+"  ( "
            + id_cloumn + " INTEGER PRIMARY KEY ,"
            + name_cloumn+" TEXT,"
            + path_cloumn+ " Integer"
            + ");";
    public static final String Piano_Table_SQL ="create table "+TABLE_NAME_PIANO+"  ( "
            + id_cloumn + " INTEGER PRIMARY KEY ,"
            + name_cloumn+" TEXT,"
            + path_cloumn+ " Integer"
            + ");";
    public static final String Electropop_Table_SQL ="create table "+TABLE_NAME_ELECTROPOP+"  ( "
            + id_cloumn + " INTEGER PRIMARY KEY ,"
            + name_cloumn+" TEXT,"
            + path_cloumn+ " Integer"
            + ");";
    private static final String Vocal_Table_SQL ="create table "+TABLE_NAME_VOCAL+"  ( "
            + id_cloumn + " INTEGER PRIMARY KEY,"
            + name_cloumn+" TEXT,"
            + path_cloumn+ " TEXT"
            + ");";
    private static final String INPUTMUSIC_Table_SQL ="CREATE TABLE "+TABLE_NAME_INPUTMUSIC+"  ( "
            + id_cloumn + "INTEGER PRIMARY KEY,"
            + no_cloumn+"Integer,"
            + path_cloumn+ " Integer"
            + ");";
    private static final String Recordmusic_Table_SQL ="CREATE TABLE "+TABLE_NAME_Recordmusic+"  ( "
            + id_cloumn + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + no_cloumn+"Integer,"
            + path_cloumn+ "Integer,"
            + frg_cloumn+ "TEXT,"
            + buttonnume_cloumn+ " TEXT"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Guitar_Table_SQL);
        db.execSQL(Electropop_Table_SQL);
        db.execSQL(Drum_Table_SQL);
        db.execSQL(Piano_Table_SQL);
        db.execSQL(Vocal_Table_SQL);
        db.execSQL(INPUTMUSIC_Table_SQL);
        db.execSQL(Recordmusic_Table_SQL);
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_GUITAR);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_ELECTROPOP);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_DRUM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_PIANO);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_VOCAL);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_INPUTMUSIC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_Recordmusic);
        onCreate(db);
    }

    public void close(){
        database.close();
    }

}
