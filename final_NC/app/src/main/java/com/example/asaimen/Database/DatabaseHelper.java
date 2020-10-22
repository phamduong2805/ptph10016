package com.example.asaimen.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asaimen.Dao.LopDao;
import com.example.asaimen.Dao.StudentDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "asimenmob201.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Lop(maLop text primary key,tenLop text)");
        db.execSQL("Create table SINHVIEN(maSV text primary key,tenSV text,maLop text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists" + LopDao.TABLE_LOP);
        db.execSQL("drop table if exists" + StudentDao.TABLE_SINHVIEN);

    }


}
