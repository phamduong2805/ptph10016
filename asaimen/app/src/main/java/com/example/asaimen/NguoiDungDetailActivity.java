package com.example.asaimen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.NguoiDung;

public class NguoiDungDetailActivity  extends AppCompatActivity {
    Button btnHuy,btnUpdate;
    NguoiDungDao nguoiDungDao;
    NguoiDung nguoiDung;

    EditText edUser, edPass, edRePass, edphone, edFullName;
    Context context;
    Intent intent;
    String hoTen,phone;
    Bundle bundle;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_detail);
        btnHuy=findViewById(R.id.btnCancel);
        btnUpdate=findViewById(R.id.btnUpdateUser);
        edFullName=findViewById(R.id.edFullName);
        edphone=findViewById(R.id.edPhone);
        nguoiDungDao = new NguoiDungDao(context);
        intent =getIntent();

        Bundle bundle = intent.getBundleExtra("bun");
        edUser.setText(bundle.getString("userName_key"));
        edPass.setText(bundle.getString("passWord_key"));
        edphone.setText(bundle.getString("phone_key"));
        edFullName.setText(bundle.getString("hoTen_key"));

    }
    public void updateUser(View view) {
        hoTen =edFullName.getText().toString();
        phone=edphone.getText().toString();
        nguoiDung= new NguoiDung();
        nguoiDung.setUserName(username);
        nguoiDung.setPassWord(password);
        nguoiDung.setPhone(phone);
        nguoiDung.setHoTen(hoTen);
        if(nguoiDungDao.update(nguoiDung)<0){
            Toast.makeText(context,"Update thanh cong",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"Update that bai",Toast.LENGTH_LONG).show();
        }

    }

    public void Huy(View view) {
    }
}
