package com.example.ontap;

public class SanPham {

    private Integer id;
    private String maSP;
    private String tenSP;
    private Integer donGiaBan;

    public SanPham() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(Integer donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public SanPham(String maSP, String tenSP, Integer donGiaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGiaBan = donGiaBan;
    }




}
