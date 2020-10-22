package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_SACH="Sach";

    public SachDao(Context context) {
        dbHelper=new DatabaseHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public int insertSach(Sach sach) {
        ContentValues values=new ContentValues();
        values.put("maSach", sach.getMaSach());
        values.put("theLoai", sach.getTheLoai());
        values.put("tenSach", sach.getTenSach());
        values.put("tacGia", sach.getTacGia());
        values.put("nsx", sach.getNsx());
        values.put("giaBan", sach.getGiaBan());
        values.put("soLuong", sach.getSoLuong());
        try {
            if (db.insert(TABLE_SACH, null, values) < 0) {
                return -1;//that bai
            }
        } catch (Exception e) {
        }
        return 1;
    }

    public List<Sach> getAllSach() {
        List<Sach> sachList=new ArrayList<>();
        Cursor cursor=db.query(TABLE_SACH, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Sach sach=new Sach();
            sach.setMaSach(cursor.getString(0));
            sach.setTheLoai(cursor.getString(1));
            sach.setTenSach(cursor.getString(2));
            sach.setTacGia(cursor.getString(3));
            sach.setNsx(cursor.getString(4));
            sach.setGiaBan(cursor.getString(5));
            sach.setSoLuong(cursor.getString(6));
            sachList.add(sach);
            cursor.moveToNext();

        }
        cursor.close();
        return sachList;
    }

    public int DeleteSach(String masach) {
        int kq=db.delete(TABLE_SACH, "maSach=?", new String[]{masach});
        if (kq == 0) {
            return -1;
        }
        return 1;
    }

    public int UpdateSach(Sach sach) {
        ContentValues values=new ContentValues();
        values.put("theLoai", sach.getTheLoai());
        values.put("tenSach", sach.getTenSach());
        values.put("tacGia", sach.getTacGia());
        values.put("nsx", sach.getNsx());
        values.put("giaBan", sach.getGiaBan());
        values.put("soLuong", sach.getSoLuong());
        int kq=db.update(TABLE_SACH, values, "maSach=?", new String[]{String.valueOf(sach.getMaSach())});
        if (kq == 0) {
            return -1;
        }
        return 1;

    }


}
