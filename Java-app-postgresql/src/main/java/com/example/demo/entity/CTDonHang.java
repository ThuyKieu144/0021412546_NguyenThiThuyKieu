package com.example.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ctdonhang")
public class CTDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ctdh_id;

    @ManyToOne
    @JoinColumn(name = "ctdh_dh_id", referencedColumnName = "dh_id")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "ctdh_sp_id", referencedColumnName = "sp_id")
    private Sanpham sanPham;

    @Column(name = "ctdh_soluong")
    private Integer ctdh_soluong;

    @Column(name = "ctdh_gia", precision = 10, scale = 2)
    private BigDecimal ctdh_gia;

    public CTDonHang(){}

    public CTDonHang(BigDecimal ctdh_gia, Integer ctdh_soluong, Sanpham sanPham, DonHang donHang) {
        this.ctdh_gia = ctdh_gia;
        this.ctdh_soluong = ctdh_soluong;
        this.sanPham = sanPham;
        this.donHang = donHang;
    }

    public Integer getCtdh_id() {
        return ctdh_id;
    }

    public void setCtdh_id(Integer ctdh_id) {
        this.ctdh_id = ctdh_id;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public Sanpham getSanPham() {
        return sanPham;
    }

    public void setSanPham(Sanpham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getCtdh_soluong() {
        return ctdh_soluong;
    }

    public void setCtdh_soluong(Integer ctdh_soluong) {
        this.ctdh_soluong = ctdh_soluong;
    }

    public BigDecimal getCtdh_gia() {
        return ctdh_gia;
    }

    public void setCtdh_gia(BigDecimal ctdh_gia) {
        this.ctdh_gia = ctdh_gia;
    }
}

