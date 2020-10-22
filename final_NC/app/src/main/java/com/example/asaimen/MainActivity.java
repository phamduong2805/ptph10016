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
    public void sudent(View view){
        Intent intent = new Intent(this,StudentActivity.class);
        startActivity(intent);

    }
    public void maps(View view){
        Intent intent = new Intent(this,MapsAcitivity.class);
        startActivity(intent);
    }
    public void news(View view){
        Intent intent = new Intent(this,NewsActivity.class);
        startActivity(intent);
    }
    public void social(View view){
        Intent intent = new Intent(this,SocialsActivity.class);
        startActivity(intent);
    }
}