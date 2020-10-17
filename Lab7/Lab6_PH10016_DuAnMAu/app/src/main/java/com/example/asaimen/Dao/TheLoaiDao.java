package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String  TABLE_THELOAI="TheLoai";
    public static String tag="TheLoaiDao";

    public TheLoaiDao(Context context) {
        this.dbHelper=new DatabaseHelper(context);
        this.db=dbHelper.getWritableDatabase();
    }

    public int insertTheLoai(TheLoai theLoai) {
        ContentValues values=new ContentValues();
        values.put("maTL", theLoai.getMaTL());
        values.put("tenTL", theLoai.getTenTL());
        values.put("viTri", theLoai.getViTri());
        values.put("moTa", theLoai.getMoTa());
        try {
            if (db.insert(TABLE_THELOAI, null, values) < 0) {
                return -1;
            }
        } catch (Exception e) {
        }
        return 1;
    }

    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> theLoaiList=new ArrayList<>();
        Cursor cursor=db.query(TABLE_THELOAI, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            TheLoai theLoai=new TheLoai();
            theLoai.setMaTL(cursor.getString(0));
            theLoai.setTenTL(cursor.getString(1));
            theLoai.setViTri(cursor.getString(2));
            theLoai.setMoTa(cursor.getString(3));
            theLoaiList.add(theLoai);
            cursor.moveToNext();
        }
        cursor.close();
        return theLoaiList;
    }

    public int DeleteTheLoai(String malt) {
        int kq=db.delete(TABLE_THELOAI, "maTL=?", new String[]{malt});
        if (kq == 0) {
            return -1;
        }
        return 1;
    }
    public int updateTheLoai(TheLoai theLoai){
        ContentValues values = new ContentValues();
        values.put("tenTL",theLoai.getTenTL());
        values.put("viTri",theLoai.getViTri());
        int kq= db.update(TABLE_THELOAI,values,"maTL=?",new String[]{String.valueOf(theLoai.getMaTL())});
        if (kq==0){
            return -1;
        }
        return 1;
    }
}
