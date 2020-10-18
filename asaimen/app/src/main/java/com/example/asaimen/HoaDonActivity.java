package com.example.asaimen;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.example.asaimen.Dao.HoaDonDao;
import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.HoaDon;
import com.example.asaimen.Model.NguoiDung;

import android.widget.DatePicker;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class HoaDonActivity  extends AppCompatActivity  {
EditText edtMaHoaDon,edtNgayMua;
HoaDonDao hoaDonDao;
Button button;
    Date date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        edtMaHoaDon=findViewById(R.id.edMaHoaDon);
        edtNgayMua=findViewById(R.id.edNgayMua);


    }


    public void datePicker(View view) {
//        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        final int day = cal.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePickerDialog;
//
//        datePickerDialog = new DatePickerDialog(HoaDonActivity.this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                edtNgayMua.setText(year+"/"+(month+1)+"/"+day);
//
//            }
//        },year,month,day);
//        datePickerDialog.show();

        final Calendar calendar =Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
      int month = calendar.get(Calendar.MONTH);
      final int day = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog( this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set( i,i1,i2 );
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
edtNgayMua.setText( simpleDateFormat.format( calendar.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();

    }

    public void ADDHoaDon(View view) {
        try {
             date1 = new SimpleDateFormat("dd/MM/yyyy").parse(edtNgayMua.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        hoaDonDao=new HoaDonDao(HoaDonActivity.this);
        HoaDon hoaDon = new HoaDon(edtMaHoaDon.getText().toString(),date1);

        try {
            if (hoaDonDao.insertHoaDon(hoaDon) > 0) {
                Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Them That Bai", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("Loi", e.toString());
        }
    }

    public void showHoaDon(View view) {
        Intent intent = new Intent(this,ListHoaDonActivity.class);
        startActivity(intent);
    }


    public void hoaDonChiTiet(View view) {
        Intent intent = new Intent( this,HoaDonChiTietActivity.class );
        startActivity( intent );
    }
}
