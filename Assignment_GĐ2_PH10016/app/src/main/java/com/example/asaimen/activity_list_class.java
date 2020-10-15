package com.example.asaimen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.asaimen.Adapter.LopAdapter;
import com.example.asaimen.Dao.LopDao;
import com.example.asaimen.Model.Lop;

import java.util.ArrayList;
import java.util.List;

public class activity_list_class extends AppCompatActivity {
    ListView listView;
    LopAdapter adapter = null;
    public static List<Lop> lopList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);
        listView = findViewById(R.id.ltvListClass);
        LopDao lopDao= new LopDao(activity_list_class.this);
        lopList  =lopDao.getAllLop();
        adapter = new LopAdapter(activity_list_class.this,lopList);
        listView.setAdapter(adapter);
    }
}