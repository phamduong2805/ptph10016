package com.example.asaimen.Model;

public class Sach {
    public String maSach;
    public String theLoai;
    public String tenSach;
    public String tacGia;
    public String nsx;
    public String giaBan;
    public String soLuong;

    public Sach() {
    }


    public Sach(String maSach, String theLoai, String tenSach, String tacGia, String nsx, String giaBan, String soLuong) {
        this.maSach=maSach;
        this.theLoai=theLoai;
        this.tenSach=tenSach;
        this.tacGia=tacGia;
        this.nsx=nsx;
        this.giaBan=giaBan;
        this.soLuong=soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach=maSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai=theLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach=tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia=tacGia;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx=nsx;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan=giaBan;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong=soLuong;
    }
}
