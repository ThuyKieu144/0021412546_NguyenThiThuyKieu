package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "donhang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dh_id;

    @Column(name = "dh_ngaydat")
    private Date dh_ngaydat;

    @Column(name = "dh_tenkh", length = 100)
    private String dh_tenkh;

    @Column(name = "dh_diachi", length = 255)
    private String dh_diachi;

    @Column(name = "dh_sdt", length = 15)
    private String dh_sdt;

    @Column(name = "dh_emailkh", length = 100)
    private String dh_emailkh;

    @ManyToOne
    @JoinColumn(name = "dh_trangthaiid", referencedColumnName = "trangthaidh_id")
    private TrangThaiDH trangthaiDH;

    @OneToMany(mappedBy = "donHang") // Assuming CTDonHang has a reference to DonHang
    private List<CTDonHang> ctDonHangList;

    public DonHang(){}

    public String getDh_sdt() {
        return dh_sdt;
    }

    public void setDh_sdt(String dh_sdt) {
        this.dh_sdt = dh_sdt;
    }

    public Integer getDh_id() {
        return dh_id;
    }

    public void setDh_id(Integer dh_id) {
        this.dh_id = dh_id;
    }

    public Date getDh_ngaydat() {
        return dh_ngaydat;
    }

    public void setDh_ngaydat(Date dh_ngaydat) {
        this.dh_ngaydat = dh_ngaydat;
    }

    public String getDh_tenkh() {
        return dh_tenkh;
    }

    public void setDh_tenkh(String dh_tenkh) {
        this.dh_tenkh = dh_tenkh;
    }

    public String getDh_diachi() {
        return dh_diachi;
    }

    public void setDh_diachi(String dh_diachi) {
        this.dh_diachi = dh_diachi;
    }

    public String getDh_emailkh() {
        return dh_emailkh;
    }

    public void setDh_emailkh(String dh_emailkh) {
        this.dh_emailkh = dh_emailkh;
    }

    public TrangThaiDH gettrangthaiDH() {
        return trangthaiDH;
    }

    public void setTrangThaiDH(TrangThaiDH trangThaiDH) {
        this.trangthaiDH = trangThaiDH;
    }

}