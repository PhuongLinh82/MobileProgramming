package com.example.ontap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase {
    SQLiteDatabase database;
    DBHelper dbHelper;

    private String[] allColumns = {DBHelper.COL_ID, DBHelper.COL_MASP, DBHelper.COL_TENSP, DBHelper.COL_DONGIABAN};

    public MyDatabase(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public SanPham createSanPham(String maSP, String tenSP, Integer donGiaBan) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COL_MASP, maSP);
        cv.put(DBHelper.COL_TENSP, tenSP);
        cv.put(DBHelper.COL_DONGIABAN, donGiaBan);
        long insertId = database.insert(DBHelper.TABLE_NAME, null, cv);
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, DBHelper.COL_ID + "=" + insertId, null, null, null, null);
        cursor.moveToFirst();
        SanPham sanPham = cursorToSanPham(cursor);
        cursor.close();
        return sanPham;
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhamList = new ArrayList<SanPham>();

        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, null, null, null, null, null);
        while (!cursor.isAfterLast()) {
            SanPham sanPham = cursorToSanPham(cursor);
            sanPhamList.add(sanPham);
            cursor.moveToNext();
        }
        cursor.close();
        return sanPhamList;
    }

    public void deleteSanPham(String maSP) {
        int deleteId = database.delete(DBHelper.TABLE_NAME, "maSP=?", new String[]{maSP});
    }

    public void updateSanPham(String originalMaSP, String maSP, String tenSP, Integer donGiaBan) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COL_MASP, maSP);
        cv.put(DBHelper.COL_TENSP, tenSP);
        cv.put(DBHelper.COL_DONGIABAN, donGiaBan);
        int updateId = database.update(DBHelper.TABLE_NAME, cv, "name=?", new String[]{originalMaSP});
    }

    private SanPham cursorToSanPham(Cursor cursor) {
        SanPham sanPham = new SanPham();
        sanPham.setId(cursor.getInt(0));
        sanPham.setMaSP(cursor.getString(1));
        sanPham.setTenSP(cursor.getString(2));
        sanPham.setDonGiaBan(cursor.getInt(3));
        return sanPham;
    }
}
