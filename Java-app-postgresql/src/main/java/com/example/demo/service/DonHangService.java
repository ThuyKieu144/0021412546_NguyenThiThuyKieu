package com.example.demo.service;

import com.example.demo.entity.CTDonHang;
import com.example.demo.entity.DonHang;
import com.example.demo.entity.TrangThaiDH;
import com.example.demo.repository.CTDonHangRepository;
import com.example.demo.repository.DonHangRepository;
import com.example.demo.repository.TrangThaiDHRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonHangService {

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private TrangThaiDHRepository trangThaiDHRepository;

    @Autowired
    private CTDonHangRepository ctDonHangRepository;

    public List<DonHang> getAllDonHangs() {
        return donHangRepository.findAll();
    }

    @Transactional
    public DonHang createOrder(DonHang donHang) {
        return donHangRepository.save(donHang); // Save the new order and return it
    }

    @Transactional
    public void addOrderDetails(Integer orderId, List<CTDonHang> details) {
        DonHang existingOrder = donHangRepository.findByOrderId(orderId);
        if (existingOrder == null) {
            throw new RuntimeException("Order not found");
        }

        // Associate the order details with the found order
        for (CTDonHang detail : details) {
            detail.setDonHang(existingOrder); // Set the DonHang for each CTDonHang
            ctDonHangRepository.save(detail); // Save each CTDonHang (order detail)
        }
    }


    public DonHang saveDonHang(DonHang donHang) {
        return donHangRepository.save(donHang);
    }

//    public void deleteDonHang(Integer id) {
//        donHangRepository.deleteById(id);
//    }

    public long countOrders() {
        return donHangRepository.count();
    }

    public DonHang updateTrangThai(Integer dh_id, Integer trangThaiId) {
        DonHang donHang = donHangRepository.findById(dh_id).orElse(null);
        if (donHang != null) {
            TrangThaiDH trangThai = trangThaiDHRepository.findById(trangThaiId).orElse(null);
            donHang.setTrangThaiDH(trangThai);
            return donHangRepository.save(donHang);
        }
        return null;
    }
    public DonHang getDonHangById(Integer id) {
        return donHangRepository.findById(id).orElse(null);
    }

    //tìm đơn bằng email
    public List<DonHang> getOrdersByCustomerEmail(String email) {
        return donHangRepository.findByCustomerEmail(email);
    }

//    public List<CTDonHang> getOrderProducts(Integer orderId) {
//        return ctDonHangRepository.findByDonHangId(orderId);
//    }
}

