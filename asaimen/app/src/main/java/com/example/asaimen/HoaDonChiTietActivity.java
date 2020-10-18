package com.example.asaimen;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Adapter.HoDonChiTietRecAdapter;
import com.example.asaimen.Adapter.HoaDonChiTietAdapter;
import com.example.asaimen.Dao.HoaDonChiTietDao;
import com.example.asaimen.Model.HoaDonChiTiet;
import com.example.asaimen.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietActivity extends AppCompatActivity {
    EditText edMaHoaDon, edMaSach, edSoLuongMua;
    RecyclerView rcCart;
    TextView tvThanhTien;
    HoaDonChiTietDao hoaDonChiTietDao;
    HoaDonChiTietAdapter hoaDonChiTietAdapter;
    List<HoaDonChiTiet> hoaDonChiTietList;
    ListView lvCart;
    int gia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);
        edMaHoaDon=findViewById(R.id.edMaHoaDon);
        edMaSach=findViewById(R.id.edMaSach);
        edSoLuongMua=findViewById(R.id.edSoLuongMua);
        tvThanhTien=findViewById( R.id.tvThanhTien );
       // rcCart=findViewById(R.id.rcCart);

//        hoaDonChiTietDao = new HoaDonChiTietDao(HoaDonChiTietActivity.this);
//        hoaDonChiTietList=hoaDonChiTietDao.getAllHoaDonChiTiet();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rcCart.setLayoutManager(linearLayoutManager);
//
//        HoDonChiTietRecAdapter adapter = new HoDonChiTietRecAdapter(HoaDonChiTietActivity.this,hoaDonChiTietList);
//        rcCart.setAdapter(adapter);



        lvCart = findViewById(R.id.lvCart);
        hoaDonChiTietDao = new HoaDonChiTietDao(HoaDonChiTietActivity.this);
        hoaDonChiTietList = hoaDonChiTietDao.getAllHoaDonChiTiet();
        hoaDonChiTietAdapter = new HoaDonChiTietAdapter(this,hoaDonChiTietList);
        lvCart.setAdapter(hoaDonChiTietAdapter);

    }

    public void ADDHoaDonCHITIET(View view) {
        HoaDonChiTietDao hoaDonChiTietDao=new HoaDonChiTietDao(HoaDonChiTietActivity.this);
        HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet(edMaHoaDon.getText().toString(), edMaSach.getText().toString(), edSoLuongMua.getText().toString());
hoaDonChiTietList.add(hoaDonChiTiet);
        try {
            if (hoaDonChiTietDao.insertHoaDonChiTiet(hoaDonChiTiet) > 0) {
                Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
                hoaDonChiTietAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getApplicationContext(), "Them That Bai", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hoaDonChiTietList.clear();//xoa cai cu
        hoaDonChiTietList = hoaDonChiTietDao.getAllHoaDonChiTiet();//lay lai cai moi
        hoaDonChiTietAdapter.changeDataset(hoaDonChiTietList);
    }

    public void thanhToanHoaDon(View view) {

    }
}
