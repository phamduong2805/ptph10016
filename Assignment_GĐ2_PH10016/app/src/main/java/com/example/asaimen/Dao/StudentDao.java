package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.Lop;
import com.example.asaimen.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;
    public static final String TABLE_SINHVIEN="SINHVIEN";
    public static final String TAG="LopDao";

    public StudentDao(Context context) {
        dbhelper=new DatabaseHelper(context);
        db=dbhelper.getWritableDatabase();
    }

    public int insertStudent(Student student) {
        ContentValues values=new ContentValues();
        values.put("maSV", student.getMaSV());
        values.put("tenSV", student.getTenSV());
        values.put("maLop",student.getMaLop());
        try {
            if (db.insert(TABLE_SINHVIEN, null, values) < 0) {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public List<Student> getAllStuden() {
        List<Student> studentList=new ArrayList<>();
        Cursor cursor=db.query(TABLE_SINHVIEN, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {//neu khong phai bang ghi cuoi cung
            Student student = new Student();
            student.setMaSV(cursor.getString(0));
            student.setTenSV(cursor.getString(1));
            student.setMaLop(cursor.getString(2));
            studentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return studentList;
    }
    public int DeleteStudent(String malop){
     int kq = db.delete(TABLE_SINHVIEN,"maSV=?",new String[]{malop});
     if(kq==0){
         return -1;
     }
     return 1;
    }

}
