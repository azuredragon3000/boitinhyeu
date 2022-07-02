package com.myapp.lovetest_azuredragon3000.congiap12.model;

public class ModelCungMang {
    private int namSinh;
    private String amLich;
    private int gioiTinh;
    private String mang;
    private String cung;
    private String hanh;

    public ModelCungMang() {
    }

    public ModelCungMang(int namSinh, String amLich, int gioiTinh, String mang, String cung, String hanh) {
        this.namSinh = namSinh;
        this.amLich = amLich;
        this.gioiTinh = gioiTinh;
        this.mang = mang;
        this.cung = cung;
        this.hanh = hanh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getAmLich() {
        return amLich;
    }

    public void setAmLich(String amLich) {
        this.amLich = amLich;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMang() {
        return mang;
    }

    public void setMang(String mang) {
        this.mang = mang;
    }

    public String getCung() {
        return cung;
    }

    public void setCung(String cung) {
        this.cung = cung;
    }

    public String getHanh() {
        return hanh;
    }

    public void setHanh(String hanh) {
        this.hanh = hanh;
    }
}
