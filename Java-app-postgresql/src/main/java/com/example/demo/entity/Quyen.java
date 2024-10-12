package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quyen")
public class Quyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quyen_id")
    private Integer quyen_id;

    @Column(name = "quyen_ten", length = 20, nullable = false)
    private String quyen_ten;


    // Hàm khởi tạo không tham số
    public Quyen() {}

    // Hàm khởi tạo với tên quyền
    public Quyen(String quyen_ten) {
        this.quyen_ten = quyen_ten;
    }

    // Getter và Setter cho quyen_id
    public Integer getQuyen_id() {
        return quyen_id;
    }

    public void setQuyen_id(Integer quyen_id) {
        this.quyen_id = quyen_id;
    }

    // Getter và Setter cho quyen_ten
    public String getQuyen_ten() {
        return quyen_ten;
    }

    public void setQuyen_ten(String quyen_ten) {
        this.quyen_ten = quyen_ten;
    }

}
