package com.example.asaimen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Adapter.TheLoaiRecAdapter;
import com.example.asaimen.Dao.TheLoaiDao;
import com.example.asaimen.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoaiActivity extends AppCompatActivity {
Intent intent;
public static List<TheLoai> theLoaiList = new ArrayList<>();
ListView lvTheLoai;
TheLoaiDao theLoaiDao;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);
        recyclerView=findViewById(R.id.rcTheLoai);
        theLoaiDao= new TheLoaiDao(ListTheLoaiActivity.this);
        theLoaiList=theLoaiDao.getAllTheLoai();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        TheLoaiRecAdapter adapter = new TheLoaiRecAdapter(ListTheLoaiActivity.this,theLoaiList);
        recyclerView.setAdapter(adapter);

    }
}
