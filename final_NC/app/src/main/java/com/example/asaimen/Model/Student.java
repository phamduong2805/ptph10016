package com.example.asaimen.Model;

public class Student {
    public String maSV;
    public String tenSV;
    public String maLop;


    public Student() {
    }

    public Student(String maSV, String tenSV, String maLop) {
        this.maSV=maSV;
        this.tenSV=tenSV;
        this.maLop=maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV=maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV=tenSV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop=maLop;
    }
}
