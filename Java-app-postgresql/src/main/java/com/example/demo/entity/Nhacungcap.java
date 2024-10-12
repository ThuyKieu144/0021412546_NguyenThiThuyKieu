package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table (name="nhacungcap")
public class Nhacungcap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ncc_id;
    private String ncc_ten;
    private String ncc_diachi;
    private String ncc_sdt;
    private String ncc_email;

    public Nhacungcap(){}

    public Nhacungcap(String ncc_ten, String ncc_diachi, String ncc_sdt, String ncc_email) {
        this.ncc_ten = ncc_ten;
        this.ncc_diachi = ncc_diachi;
        this.ncc_sdt = ncc_sdt;
        this.ncc_email = ncc_email;
    }

    public Integer getNcc_id() {
        return ncc_id;
    }

    public void setNcc_id(Integer ncc_id) {
        this.ncc_id = ncc_id;
    }

    public String getNcc_ten() {
        return ncc_ten;
    }

    public void setNcc_ten(String ncc_ten) {
        this.ncc_ten = ncc_ten;
    }

    public String getNcc_diachi() {
        return ncc_diachi;
    }

    public void setNcc_diachi(String ncc_diachi) {
        this.ncc_diachi = ncc_diachi;
    }

    public String getNcc_sdt() {
        return ncc_sdt;
    }

    public void setNcc_sdt(String ncc_sdt) {
        this.ncc_sdt = ncc_sdt;
    }

    public String getNcc_email() {
        return ncc_email;
    }

    public void setNcc_email(String ncc_email) {
        this.ncc_email = ncc_email;
    }
}
