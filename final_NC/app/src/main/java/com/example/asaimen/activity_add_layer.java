package com.example.asaimen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asaimen.Dao.LopDao;
import com.example.asaimen.Model.Lop;

import java.util.ArrayList;
import java.util.List;

public class activity_add_layer extends AppCompatActivity {
    EditText edtMalop, edtTenLop;
    Button btnXoa, btnThemLop;

    List<Lop> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layer);
        edtMalop=findViewById(R.id.txtclassID);
        edtTenLop=findViewById(R.id.txtClassName);
        btnXoa=findViewById(R.id.btnClear);
        btnThemLop=findViewById(R.id.btnCreateClass);




    }

    public void addLop(View view) {
        LopDao lopDao=new LopDao(activity_add_layer.this);
        Lop lop=new Lop( edtMalop.getText().toString(),edtTenLop.getText().toString());
        list.add(lop);

        try {
            if (lopDao.insertLop(lop) > 0) {
                Toast.makeText(getApplicationContext(), "Them thanh cong", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Them that bai",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){

        }
    }


}