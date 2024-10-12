package com.example.demo.repository;

import com.example.demo.entity.CTDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTDonHangRepository extends JpaRepository<CTDonHang, Integer> {

    // Sử dụng truy vấn tùy chỉnh để lấy các chi tiết đơn hàng theo dh_id
    @Query("SELECT c FROM CTDonHang c WHERE c.donHang.dh_id = :donHangId")
    List<CTDonHang> findByDonHangId(@Param("donHangId") Integer donHangId);

}
