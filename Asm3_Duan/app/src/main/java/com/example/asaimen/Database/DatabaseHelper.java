package com.example.asaimen.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asaimen.Dao.HoaDonChiTietDao;
import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Dao.SachDao;
import com.example.asaimen.Dao.TheLoaiDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "asa.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table NguoiDung(userName text primary key,passWord text,phone text,hoTen text)");
        db.execSQL("Create table TheLoai(maTL text primary key,tenTL text,viTri text,moTa text)");
        db.execSQL("Create table Sach(maSach text primary key,theLoai text,tenSach text,tacGia text,nsx text,giaBan text,soLuong text)");
        db.execSQL("Create table HoaDonChiTiet(maHoaDon text primary key,maSach text,soLuongMua text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists" + NguoiDungDao.TABLE_NAME);
        db.execSQL("drop table if exists" + TheLoaiDao.TABLE_THELOAI);
        db.execSQL("drop table if exists" + SachDao.TABLE_SACH);
        db.execSQL("drop table if exists"+ HoaDonChiTietDao.TABLE_HOADONCHITIET);
    }
}
