package com.example.asaimen.Model;

public class TheLoai {
    public String maTL;
    public String tenTL;
    public String viTri;
    public String moTa;

    public TheLoai() {
    }

    public TheLoai(String maTL, String tenTL, String viTri, String moTa) {
        this.maTL=maTL;
        this.tenTL=tenTL;
        this.viTri=viTri;
        this.moTa=moTa;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL=maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL=tenTL;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri=viTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa=moTa;
    }
}
