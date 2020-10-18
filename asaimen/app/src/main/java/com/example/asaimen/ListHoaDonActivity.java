package com.example.asaimen;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asaimen.Adapter.HoaDonAdapter;
import com.example.asaimen.Adapter.HoaDonChiTietAdapter;
import com.example.asaimen.Adapter.NguoiDungAdapter;
import com.example.asaimen.Dao.HoaDonChiTietDao;
import com.example.asaimen.Dao.HoaDonDao;
import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.HoaDon;
import com.example.asaimen.Model.NguoiDung;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ListHoaDonActivity extends AppCompatActivity {
ListView listView;
    Intent intent;
    public static List<HoaDon> dsHoaDon=new ArrayList<>();
    ListView lvNguoiDung;
   HoaDonDao hoaDonDao;
    HoaDonAdapter adapter=null;
    EditText edSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_don);
        listView=findViewById(R.id.lvHoaDon);
        edSearch=findViewById(R.id.edSearch);




        hoaDonDao = new HoaDonDao(ListHoaDonActivity.this);
        try {
            dsHoaDon = hoaDonDao.getAllHoaDon();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        adapter = new HoaDonAdapter(this,dsHoaDon);
        listView.setAdapter(adapter);



    }


}