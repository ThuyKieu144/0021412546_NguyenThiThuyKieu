package com.example.demo.repository;

import com.example.demo.entity.CTDonHang;
import com.example.demo.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,Integer> {
    // Custom query to handle the field with an underscore
    @Query("SELECT t FROM TaiKhoan t WHERE t.taikhoan_email = :email")
    TaiKhoan findByEmail(@Param("email") String email);

    //kiểm tra email tồn tại
//    boolean existsByTaiKhoanEmail(String email);
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TaiKhoan t WHERE t.taikhoan_email = :email")
    boolean existsByTaiKhoanEmail(@Param("email") String email);

}
