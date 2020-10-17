package com.example.asaimen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asaimen.Adapter.SpinerAdapter;
import com.example.asaimen.Dao.SachDao;
import com.example.asaimen.Dao.TheLoaiDao;
import com.example.asaimen.Model.Sach;
import com.example.asaimen.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ThemSachActivity extends AppCompatActivity {
    EditText edtMaSach, edtTenSach, edtTacGia, edtNSX, edtGiaBan, edtSoLuong;
    Spinner spTheLoai;
    TheLoaiDao theLoaiDao;
    List<TheLoai> theLoaiList;
    String matheloai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        edtMaSach=findViewById(R.id.edMaSach);
        edtTenSach=findViewById(R.id.edTenSach);
        edtTacGia=findViewById(R.id.edTacGia);
        edtNSX=findViewById(R.id.edNXB);
        edtGiaBan=findViewById(R.id.edGiaBia);
        edtSoLuong=findViewById(R.id.edSoLuong);
        spTheLoai=findViewById(R.id.spnTheLoai);
        theLoaiDao=new TheLoaiDao(ThemSachActivity.this);
        theLoaiList=new ArrayList<>();
        theLoaiList=theLoaiDao.getAllTheLoai();

        SpinerAdapter myAdapter=new SpinerAdapter(ThemSachActivity.this, theLoaiList);
        spTheLoai.setAdapter(myAdapter);
        spTheLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              TheLoai loai =theLoaiList.get(i);
              matheloai=loai.getMaTL();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void addBook(View view) {
        SachDao sachDao=new SachDao(ThemSachActivity.this);
        Sach sach=new Sach(edtMaSach.getText().toString(), matheloai, edtTenSach.getText().toString(),
                edtTacGia.getText().toString(), edtNSX.getText().toString(), edtGiaBan.getText().toString(), edtSoLuong.getText().toString());
        try {
            if (sachDao.insertSach(sach) > 0) {
                Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Them That Bai", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {

        }


    }

    public void showBook(View view) {
        Intent intent = new Intent(ThemSachActivity.this,ListBookActivity.class);
        startActivity(intent);
    }
}
