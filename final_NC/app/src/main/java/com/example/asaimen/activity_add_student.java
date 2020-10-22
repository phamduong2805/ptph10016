package com.example.asaimen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asaimen.Adapter.SpinnerAdapter;
import com.example.asaimen.Adapter.StudentAdapter;
import com.example.asaimen.Dao.LopDao;
import com.example.asaimen.Dao.StudentDao;
import com.example.asaimen.Model.Lop;
import com.example.asaimen.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class activity_add_student extends AppCompatActivity {
    EditText edtMaSV, edtTenSV, edtSpinner;
    Spinner spinner;
    ListView listViewSV;
    Intent intent;
    List<Lop> lopList;
    String malopt;
    LopDao lopDao;
    public static List<Student> studentList=new ArrayList<>();
    StudentAdapter adapter;
    Student student=new Student();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        edtMaSV=findViewById(R.id.txtStuderID);
        edtTenSV=findViewById(R.id.txtStuderName);
        spinner=findViewById(R.id.spnListClass);
        listViewSV=findViewById(R.id.ltListStudent);
        lopDao=new LopDao(activity_add_student.this);
        lopList=new ArrayList<>();
        lopList=lopDao.getAllLop();

        SpinnerAdapter myAdapter=new SpinnerAdapter(activity_add_student.this, lopList);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Lop loptx=lopList.get(i);
                malopt=loptx.getMaLop();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
            StudentDao studentDao=new StudentDao(activity_add_student.this);
            studentList=studentDao.getAllStuden();
            adapter=new StudentAdapter(activity_add_student.this, studentList);
            listViewSV.setAdapter(adapter);
    }

    public void themSinhVien(View view) {
        StudentDao studentDao=new StudentDao(activity_add_student.this);
        Student student=new Student( edtMaSV.getText().toString(), edtTenSV.getText().toString(),malopt);
        studentList.add(student);
        try {
            if (studentDao.insertStudent(student) > 0) {
                Toast.makeText(getApplicationContext(), "Them thanh cong", Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
                finish();
                startActivity(getIntent());
            } else {
                Toast.makeText(getApplicationContext(), "Them that bai", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {

        }
    }

}