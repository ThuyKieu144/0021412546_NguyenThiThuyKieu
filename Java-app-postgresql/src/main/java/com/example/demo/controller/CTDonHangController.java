package com.example.demo.controller;

import com.example.demo.entity.CTDonHang;
import com.example.demo.service.CTDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ctDH")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})

public class CTDonHangController {

    @Autowired
    private CTDonHangService cTDonHangService;

    @GetMapping("/by-donhang/{donHangId}")
    public List<CTDonHang> getCTDonHangByDonHangId(@PathVariable Integer donHangId) {
        return cTDonHangService.getCTDonHangByDonHangId(donHangId);
    }

    @PostMapping
    public CTDonHang createCTDonHang(@RequestBody CTDonHang cTDonHang) {
        return cTDonHangService.saveCTDonHang(cTDonHang);
    }

    // Phương thức mới để tạo nhiều chi tiết đơn hàng
    @PostMapping("/batch")
    public List<CTDonHang> createCTDonHangs(@RequestBody List<CTDonHang> cTDonHangList) {
        return cTDonHangService.saveCTDonHangs(cTDonHangList);
    }

}

