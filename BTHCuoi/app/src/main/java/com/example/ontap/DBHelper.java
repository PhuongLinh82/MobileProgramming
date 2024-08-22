package com.example.ontap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QUAN_LY_SAN_PHAM";
    public static final String TABLE_NAME = "SANPHAM";
    public static final String COL_ID = "ID";
    public static final String COL_MASP= "MASP";
    public static final String COL_TENSP = "TENSP";
    public static final String COL_DONGIABAN = "DONGIABAN";
    public static final String CREATE_SANPHAM_TABLE = "create table " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement ," + COL_MASP + " text not null," + COL_TENSP + " text not null ," + COL_DONGIABAN + " integer not null )";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SANPHAM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
