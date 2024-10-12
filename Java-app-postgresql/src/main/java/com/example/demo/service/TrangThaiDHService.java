package com.example.demo.service;

import com.example.demo.entity.TrangThaiDH;
import com.example.demo.repository.TrangThaiDHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrangThaiDHService {
    @Autowired
    private TrangThaiDHRepository trangThaiDHRepository;

    public List<TrangThaiDH> getAllTrangThaiDH() {
        return trangThaiDHRepository.findAll();
    }

    public Optional<TrangThaiDH> getTrangThaiDHById(int id) {
        return trangThaiDHRepository.findById(id);
    }

    public TrangThaiDH createTrangThaiDH(TrangThaiDH trangThaiDH) {
        return trangThaiDHRepository.save(trangThaiDH);
    }

    public TrangThaiDH updateTrangThaiDH(int id, TrangThaiDH trangThaiDH) {
        Optional<TrangThaiDH> existing = trangThaiDHRepository.findById(id);
        if (existing.isPresent()) {
            TrangThaiDH updatedTrangThaiDH = existing.get();
            updatedTrangThaiDH.setTrangthaidh_ten(trangThaiDH.getTrangthaidh_ten());
            return trangThaiDHRepository.save(updatedTrangThaiDH);
        }
        return null;
    }

    public void deleteTrangThaiDH(Integer id) {
        trangThaiDHRepository.deleteById(id);
    }
}

