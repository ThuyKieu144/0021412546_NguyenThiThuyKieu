package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "trangthaidh")
public class TrangThaiDH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trangthaidh_id")
    private Integer trangthaidh_id;

    @Column(name = "trangthaidh_ten", length = 50, nullable = false)
    private String trangthaidh_ten;

    public TrangThaiDH() {}

    public TrangThaiDH(String trangthaidh_ten) {
        this.trangthaidh_ten = trangthaidh_ten;
    }

    public Integer getTrangthaidh_id() {
        return trangthaidh_id;
    }

    public void setTrangthaidh_id(Integer trangthaidh_id) {
        this.trangthaidh_id = trangthaidh_id;
    }

    public String getTrangthaidh_ten() {
        return trangthaidh_ten;
    }

    public void setTrangthaidh_ten(String trangthaidh_ten) {
        this.trangthaidh_ten = trangthaidh_ten;
    }
}
