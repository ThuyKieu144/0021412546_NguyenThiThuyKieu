package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoan_id")
    private Integer taikhoan_id;

    @Column(name = "taikhoan_ten", length = 50, nullable = false)
    private String taikhoan_ten;

    @Column(name = "taikhoan_matkhau", length = 50, nullable = false)
    private String taikhoan_matkhau;

    @Column( unique = true,name = "taikhoan_email", length = 100, nullable = false)
    private String taikhoan_email;

    // Định nghĩa mối quan hệ Many-to-One với bảng Quyen
    @ManyToOne
    @JoinColumn(name = "taikhoan_quyen", referencedColumnName = "quyen_id", nullable = false)
    private Quyen quyen;

    // Constructor mặc định
    public TaiKhoan() {}

    // Getter và Setter cho các trường

    public Integer getTaikhoan_id() {
        return taikhoan_id;
    }

    public void setTaikhoan_id(Integer taikhoan_id) {
        this.taikhoan_id = taikhoan_id;
    }

    public String getTaikhoan_ten() {
        return taikhoan_ten;
    }

    public void setTaikhoan_ten(String taikhoan_ten) {
        this.taikhoan_ten = taikhoan_ten;
    }

    public String getTaikhoan_matkhau() {
        return taikhoan_matkhau;
    }

    public void setTaikhoan_matkhau(String taikhoan_matkhau) {
        this.taikhoan_matkhau = taikhoan_matkhau;
    }

    public String getTaikhoan_email() {
        return taikhoan_email;
    }

    public void setTaikhoan_email(String taikhoan_email) {
        this.taikhoan_email = taikhoan_email;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }
}
