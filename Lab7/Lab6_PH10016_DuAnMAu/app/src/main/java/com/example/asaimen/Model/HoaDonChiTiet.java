package com.example.asaimen.Model;

public class HoaDonChiTiet {
    public String maHoaDon;
    public String maSach;
    public String soLuongMua;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDon, String maSach, String soLuongMua) {
        this.maHoaDon=maHoaDon;
        this.maSach=maSach;
        this.soLuongMua=soLuongMua;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon=maHoaDon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach=maSach;
    }

    public String getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(String soLuongMua) {
        this.soLuongMua=soLuongMua;
    }
}
