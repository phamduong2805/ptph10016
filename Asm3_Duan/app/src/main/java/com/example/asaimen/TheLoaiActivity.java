package com.example.asaimen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asaimen.Dao.TheLoaiDao;
import com.example.asaimen.Model.TheLoai;

public class TheLoaiActivity  extends AppCompatActivity {
EditText edtMaTL,edtTenTL,edtViTri,edtMoTa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        edtMaTL=findViewById(R.id.edMaTheLoai);
        edtTenTL=findViewById(R.id.edTenTheLoai);
        edtViTri=findViewById(R.id.edViTri);
        edtMoTa =findViewById(R.id.edMoTa);


    }

    public void addTheLoai(View view) {
        TheLoaiDao theLoaiDao = new TheLoaiDao(TheLoaiActivity.this);
        TheLoai theLoai = new TheLoai(edtMaTL.getText().toString(),edtTenTL.getText().toString(),edtViTri.getText().toString(),edtMoTa.getText().toString());
        try {
            if(theLoaiDao.insertTheLoai(theLoai)>0){
                Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Them That Bai", Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){

        }
    }

    public void showTheLoai(View view) {
        Intent intent=new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
        startActivity(intent);
    }
}
