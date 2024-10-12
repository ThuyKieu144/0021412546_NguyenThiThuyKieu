package com.example.demo.service;

import com.example.demo.entity.Nhacungcap;
import com.example.demo.repository.NhacungcapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhacungcapService {
    @Autowired
    private NhacungcapRepository nhacungcapRepository;

    public List<Nhacungcap> findAll() {
        return nhacungcapRepository.findAll();
    }

    public Optional<Nhacungcap> findById(Integer id) {
        return nhacungcapRepository.findById(id);
    }

    public Nhacungcap save(Nhacungcap nhacungcap) {
        return nhacungcapRepository.save(nhacungcap);
    }

    public void deleteById(Integer id) {
        nhacungcapRepository.deleteById(id);
    }
}
