package com.example.demo.controller;

import com.example.demo.service.DoanhThuService;
import com.example.demo.service.DonHangService;
import com.example.demo.service.SanphamService;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private SanphamService sanPhamService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private DoanhThuService doanhThuService;

    // Count total products
    @GetMapping("/count/products")
    public long countProducts() {
        return sanPhamService.countProducts();
    }

    // Count total accounts
    @GetMapping("/count/accounts")
    public long countAccounts() {
        return taiKhoanService.countAccounts();
    }

    // Count total orders
    @GetMapping("/count/orders")
    public long countOrders() {
        return donHangService.countOrders();
    }

    // Get total revenue
    @GetMapping("/count/revenue")
    public BigDecimal totalRevenue() {
        return doanhThuService.calculateTotalRevenue();
    }
}
