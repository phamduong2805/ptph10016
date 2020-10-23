package com.example.asaimen.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.asaimen.Database.DatabaseHelper;
import com.example.asaimen.Model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME="NguoiDung";
    public static final String TAG="NguoiDungDao";

    //khoi tao database
    public NguoiDungDao(Context context) {
        dbHelper=new DatabaseHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public int insertNguoiDung(NguoiDung n) {
        ContentValues values=new ContentValues();
        values.put("userName", n.getUserName());
        values.put("passWord", n.getPassWord());
        values.put("phone", n.getPhone());
        values.put("hoTen", n.getHoTen());
        try {
            if (db.insert(TABLE_NAME, null, values) < 0) {//inser khong thanh cong
                return -1;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return 1;
    }

    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> dsNguoiDung=new ArrayList<>();
        Cursor cursor=db.query(TABLE_NAME, null, null,
                null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {//neu khong phai bang ghi cuoi cung
                    NguoiDung ng=new NguoiDung();
            ng.setUserName(cursor.getString(0));
            ng.setPassWord(cursor.getString(1));
            ng.setPhone(cursor.getString(2));
            ng.setHoTen(cursor.getString(3));
            dsNguoiDung.add(ng);
            Log.d("//==", ng.toString());
            cursor.moveToNext();
        }
        cursor.close();
        return dsNguoiDung;
    }
//    public int DeleteNguoiDungByID(String username){
//        int kq = db.delete(TABLE_NAME,"userName=?",new String[]{username});
//        if(kq==0){
//            return -1;//that bai
//        }
//        return 1;//thanh cong
//    }
//    //update
//    public int updateInfoNguoiDung(String username,String phone,String name){
//        ContentValues values =new ContentValues();
//        values.put("phone",phone);
//        values.put("hoTen",name);
//        int kq=db.update(TABLE_NAME,values,"userName=?",new String[]{username});
//        if(kq==0){
//            return -1;//that bai
//        }
//        return 1;//thanh cong
//    }


    //viet lai ham delete

    public int DeleteNguoiDungBuID(String username) {//xoa du lieu theo id

        //thuc thi va lay ve ket qua bang 0 khong thanh cong khac khong
        int result=db.delete(TABLE_NAME, "userName=?", new String[]{username});
        if (result == 0) {
            return -1;//that bai
        }
        return 1;//thanh cong

    }

    public int updateInfoNguoiDung(String userName, String phone, String hoTen) {
        ContentValues values=new ContentValues();//tao mang gia tri can update
        values.put("phone", phone);//them gia tri phone
        values.put("hoTen", hoTen);//them gia tri hoten
        int kq=db.update(TABLE_NAME, values, "userName=?", new String[]{userName});
        if (kq == 0) {
            return -1;//update that bai
        }
        return 1;

    }

    public int update(NguoiDung nguoiDung){
        ContentValues values=new ContentValues();//tao mang gia tri can update
     //   values.put("userName",nguoiDung.getUserName());
       // values.put("passWord",nguoiDung.getPassWord());
        values.put("phone",nguoiDung.getPhone());//them gia tri phone
        values.put("hoTen",nguoiDung.getHoTen());//them gia tri hoten
        int kq=db.update(TABLE_NAME, values, "userName=?", new String[]{String.valueOf(nguoiDung.getUserName())});
        if (kq == 0) {
            return -1;//update that bai
        }
        return 1;
    }
}
