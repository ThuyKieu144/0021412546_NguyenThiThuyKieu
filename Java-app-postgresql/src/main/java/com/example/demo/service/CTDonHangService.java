package com.example.demo.service;

import com.example.demo.entity.CTDonHang;
import com.example.demo.repository.CTDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTDonHangService {

    @Autowired
    private CTDonHangRepository cTDonHangRepository;

    public List<CTDonHang> getAllCTDonHangs() {
        return cTDonHangRepository.findAll();
    }

    public List<CTDonHang> getCTDonHangByDonHangId(Integer donHangId) {
        return cTDonHangRepository.findByDonHangId(donHangId );
    }

    // Phương thức lưu một chi tiết đơn hàng
    public CTDonHang saveCTDonHang(CTDonHang cTDonHang) {
        return cTDonHangRepository.save(cTDonHang);
    }

    // Phương thức lưu nhiều chi tiết đơn hàng
    public List<CTDonHang> saveCTDonHangs(List<CTDonHang> cTDonHangList) {
        return cTDonHangRepository.saveAll(cTDonHangList);
    }

}
