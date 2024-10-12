package com.example.demo.service;

import com.example.demo.entity.Sanpham;
import com.example.demo.repository.SanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanphamService {

    @Autowired
    private SanphamRepository sanphamRepository;

    public List<Sanpham> getAllSanpham() {
        return sanphamRepository.findAll();
    }

//    public Sanpham getSanphamById(Integer id) {
//        return sanphamRepository.findById(id).orElse(null);
//    }
    public Optional<Sanpham> getSanphamById(Integer id) {
        return sanphamRepository.findById(id);
    }


    public Sanpham saveSanpham(Sanpham sanpham) {
        return sanphamRepository.save(sanpham);
    }

    public void deleteSanpham(Integer id) {
        sanphamRepository.deleteById(id);
    }

    public long countProducts() {
        return sanphamRepository.count();
    }
}
