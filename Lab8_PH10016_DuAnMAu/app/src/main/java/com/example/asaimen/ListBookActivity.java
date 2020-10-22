package com.example.asaimen;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Adapter.SachRecAdapter;
import com.example.asaimen.Dao.SachDao;
import com.example.asaimen.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class ListBookActivity extends AppCompatActivity {
public static List<Sach> sachList = new ArrayList<>();
SachDao sachDao;
EditText edtTimKiem;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        edtTimKiem=findViewById(R.id.edSearchBook);
        recyclerView=findViewById(R.id.rcBook);

        sachDao = new SachDao(ListBookActivity.this);
        sachList=sachDao.getAllSach();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SachRecAdapter adapter = new SachRecAdapter(ListBookActivity.this,sachList);
        recyclerView.setAdapter(adapter);
    }
}
