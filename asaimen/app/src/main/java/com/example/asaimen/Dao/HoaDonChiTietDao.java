package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_HOADONCHITIET="HoaDonChiTiet";

    public HoaDonChiTietDao(Context context) {
        this.dbHelper=new DatabaseHelper(context);
        this.db=dbHelper.getWritableDatabase();
    }

    public int insertHoaDonChiTiet(HoaDonChiTiet h) {
        ContentValues values=new ContentValues();
        values.put("maHoaDon", h.getMaHoaDon());
        values.put("maSach", h.getMaSach());
        values.put("soLuongMua",h.getSoLuongMua());

        try {
            if (db.insert(TABLE_HOADONCHITIET, null, values) < 0) {
                return -1;
            }
        } catch (Exception e) {

        }
        return 1;
    }

    public List<HoaDonChiTiet> getAllHoaDonChiTiet() {
        List<HoaDonChiTiet> hoaDonChiTietList=new ArrayList<>();
        Cursor cursor=db.query(TABLE_HOADONCHITIET, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            HoaDonChiTiet chiTiet=new HoaDonChiTiet();
            chiTiet.setMaHoaDon(cursor.getString(0));
            chiTiet.setMaSach(cursor.getString(1));
            chiTiet.setSoLuongMua(cursor.getString(2));
            hoaDonChiTietList.add(chiTiet);
            cursor.moveToNext();

        }
        cursor.close();
        return hoaDonChiTietList;
    }

    public int DeleteHoDonChiTiet(String mahoadon){
            int kq=db.delete(TABLE_HOADONCHITIET,"maHoaDon=?",new String[]{mahoadon});
            if (kq==0){
                return -1;
            }
            return 1;
    }
    public int Update(HoaDonChiTiet hoaDonChiTiet){
        ContentValues values = new ContentValues();
        values.put("maSach", hoaDonChiTiet.getMaSach());
        values.put("soLuongMua", hoaDonChiTiet.getSoLuongMua());
        int kq=db.update(TABLE_HOADONCHITIET,values,"maHoaDon=?",new String[]{String.valueOf(hoaDonChiTiet.getMaHoaDon())});
        if (kq==0){
            return -1;
        }
        return 1;
    }


}
