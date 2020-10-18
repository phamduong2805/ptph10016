package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.HoaDon;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_HOA_DON="HoaDon";


    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public HoaDonDao(Context context) {
        dbHelper=new DatabaseHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public int insertHoaDon(HoaDon hd) {
        ContentValues values=new ContentValues();
        values.put("maHoaDon", hd.getMaHoaDon());
        values.put("ngayMua", sdf.format(hd.getNgayMua()));
        try {
            if (db.insert(TABLE_HOA_DON, null, values) == -1) {
                return -1;

            }
        } catch (Exception e) {
        }
        return 1;
    }
    public List<HoaDon> getAllHoaDon() throws ParseException{
        List<HoaDon> dsHoaDon = new ArrayList<>();
        Cursor c =db.query(TABLE_HOA_DON,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            HoaDon ee = new HoaDon();
            ee.setMaHoaDon(c.getString(0));
            ee.setNgayMua(sdf.parse(c.getString(1)));
            dsHoaDon.add(ee);
            c.moveToNext();
        }
        c.close();
        return dsHoaDon;
    }
    public int updateHoaDon(HoaDon hd){
        ContentValues values = new ContentValues();
        values.put("mahoadon",hd.getMaHoaDon());
        values.put("ngaymua",hd.getNgayMua().toString());
        int kq = db.update(TABLE_HOA_DON,values,"mahoadon=?",new String[]{hd.getMaHoaDon()});
        if (kq==0){
            return -1;
        }
        return 1;
    }
    public int deleteHoaDon(String mahoadon){
        int kq =db.delete(TABLE_HOA_DON,"mahoadon=?",new String[]{mahoadon});
        if (kq==0){
            return -1;
        }
        return 1;
    }
}
