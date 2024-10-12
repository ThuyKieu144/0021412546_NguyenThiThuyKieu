package com.example.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="sanpham")
public class Sanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sp_id;
    private String sp_ten;
    private BigDecimal sp_gia;
    private Integer sp_slton;
    private String sp_mota;
    private String sp_hinhanh;

    // Định nghĩa mối quan hệ Many-to-One với bảng Quyen
    @ManyToOne
    @JoinColumn(name = "sp_nhacungcapid", referencedColumnName = "ncc_id", nullable = false)
    private Nhacungcap nhacungcap;

    public Sanpham(){}

    public Integer getSp_id() {
        return sp_id;
    }

    public void setSp_id(Integer sp_id) {
        this.sp_id = sp_id;
    }

    public String getSp_ten() {
        return sp_ten;
    }

    public void setSp_ten(String sp_ten) {
        this.sp_ten = sp_ten;
    }

    public BigDecimal getSp_gia() {
        return sp_gia;
    }

    public void setSp_gia(BigDecimal sp_gia) {
        this.sp_gia = sp_gia;
    }

    public Integer getSp_slton() {
        return sp_slton;
    }

    public void setSp_slton(Integer sp_slton) {
        this.sp_slton = sp_slton;
    }

    public String getSp_mota() {
        return sp_mota;
    }

    public void setSp_mota(String sp_mota) {
        this.sp_mota = sp_mota;
    }

    public String getSp_hinhanh() {
        return sp_hinhanh;
    }

    public void setSp_hinhanh(String sp_hinhanh) {
        this.sp_hinhanh = sp_hinhanh;
    }

    public Nhacungcap getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(Nhacungcap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }
}
