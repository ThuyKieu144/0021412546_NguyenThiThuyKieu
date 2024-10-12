package com.example.demo.service;

import com.example.demo.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DoanhThuService {

    @Autowired
    private CTDonHangService ctDonHangService;

    // tính tổng doanh thu theo trangthaiid là 3 , đã giao thành công
    public BigDecimal calculateTotalRevenue() {
        return ctDonHangService.getAllCTDonHangs()
                .stream()
                .filter(chiTietDonHang -> chiTietDonHang.getDonHang().gettrangthaiDH().getTrangthaidh_id() == 3) // Only include orders with status ID 3
                .map(chiTietDonHang -> chiTietDonHang.getCtdh_gia().multiply(BigDecimal.valueOf(chiTietDonHang.getCtdh_soluong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Summing the total revenue
    }

//    // Method to calculate the total revenue
//    public BigDecimal calculateTotalRevenue() {
//        // Summing up total revenue by multiplying price and quantity for each order detail
//        return ctDonHangService.getAllCTDonHangs()
//                .stream()
//                .map(chiTietDonHang -> chiTietDonHang.getCtdh_gia().multiply(BigDecimal.valueOf(chiTietDonHang.getCtdh_soluong())))
//                .reduce(BigDecimal.ZERO, BigDecimal::add); // Summing the total revenue
//    }

}


