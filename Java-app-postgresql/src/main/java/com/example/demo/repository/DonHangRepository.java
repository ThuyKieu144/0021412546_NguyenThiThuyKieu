package com.example.demo.repository;

import com.example.demo.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    @Query("SELECT d FROM DonHang d WHERE d.dh_id = :orderId")
    DonHang findByOrderId(Integer orderId);

    // Tìm đơn hàng bằng email khách hàng
    @Query("SELECT d FROM DonHang d WHERE d.dh_emailkh = :email")
    List<DonHang> findByCustomerEmail(String email);
}
