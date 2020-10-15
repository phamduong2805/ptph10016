package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.Lop;

import java.util.ArrayList;
import java.util.List;

public class LopDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;
    public static final String TABLE_LOP="Lop";
    public static final String TAG="LopDao";

    public LopDao(Context context) {
        dbhelper=new DatabaseHelper(context);
        db=dbhelper.getWritableDatabase();
    }

    public int insertLop(Lop lop) {
        ContentValues values=new ContentValues();
        values.put("maLop", lop.getMaLop());
        values.put("tenLop", lop.getTenLop());
        try {
            if (db.insert(TABLE_LOP, null, values) < 0) {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public List<Lop> getAllLop() {
        List<Lop> listLop=new ArrayList<>();
        Cursor cursor=db.query(TABLE_LOP, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {//neu khong phai bang ghi cuoi cung
            Lop lop=new Lop();
            lop.setMaLop(cursor.getString(0));
            lop.setTenLop(cursor.getString(1));
            listLop.add(lop);
            cursor.moveToNext();
        }
        cursor.close();
        return listLop;
    }

    public int DeleteLop(String malop) {
        int kq=db.delete(TABLE_LOP, "maLop=?", new String[]{malop});
        if (kq == 0) {
            return -1;
        }
        return 1;
    }

}
