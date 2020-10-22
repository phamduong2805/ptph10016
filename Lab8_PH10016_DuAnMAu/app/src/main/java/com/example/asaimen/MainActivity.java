package com.example.asaimen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewNguoiDung(View view) {
        Intent intent = new Intent(this,NguoiDungActivity.class);
        startActivity(intent);
    }

    public void viewTheLoai(View view) {
        Intent intent = new Intent(this,TheLoaiActivity.class);
        startActivity(intent);
    }

    public void viewListBookActivity(View view) {
        Intent intent = new Intent(this,ThemSachActivity.class);
        startActivity(intent);
    }

    public void ViewListHoaDonActivity(View view) {
        Intent intent = new Intent(this,HoaDonChiTietActivity.class);
        startActivity(intent);
    }

    public void ViewTopSach(View view) {
    }

    public void ViewThongKeActivity(View view) {
    }
}