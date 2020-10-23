package com.example.asaimen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Adapter.NguoiDungAdapter;
import com.example.asaimen.Adapter.NguoiDungRecAdapter;
import com.example.asaimen.Adapter.NguoiDungRecyclerAdapter;
import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    Intent intent;
    public static List<NguoiDung> dsNguoiDung=new ArrayList<>();
    ListView lvNguoiDung;
    NguoiDungDao nguoiDungDao;
    NguoiDungAdapter adapter=null;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        //su dung listView
//        nguoiDungDao = new NguoiDungDao(ListNguoiDungActivity.this);
//        dsNguoiDung  =nguoiDungDao.getAllNguoiDung();
//        adapter = new NguoiDungAdapter(this,dsNguoiDung);
//        lvNguoiDung.setAdapter(adapter);

        //su dung recyclerView
        recyclerView=findViewById(R.id.recyclerView);
        nguoiDungDao=new NguoiDungDao(ListNguoiDungActivity.this);
        dsNguoiDung  =nguoiDungDao.getAllNguoiDung();
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

      NguoiDungRecyclerAdapter adapter =new NguoiDungRecyclerAdapter(ListNguoiDungActivity.this,dsNguoiDung);
      //  NguoiDungRecAdapter adapter = new NguoiDungRecAdapter(ListNguoiDungActivity.this,dsNguoiDung);
        recyclerView.setAdapter(adapter);




    }


    public void startThemNguoiDung(View view) {
        intent=new Intent(ListNguoiDungActivity.this, NguoiDungActivity.class);
        startActivity(intent);
    }
}
