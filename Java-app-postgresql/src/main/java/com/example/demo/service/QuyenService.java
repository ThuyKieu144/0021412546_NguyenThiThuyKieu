package com.example.demo.service;

import com.example.demo.entity.Quyen;
import com.example.demo.repository.QuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuyenService {

    @Autowired
    private QuyenRepository quyenRepository;

    // Lấy tất cả quyền
    public List<Quyen> getAllQuyens() {
        return quyenRepository.findAll();
    }

    // Lấy quyền theo ID
    public Optional<Quyen> getQuyenById(int id) {
        return quyenRepository.findById(id);
    }

    // Thêm quyền mới
    public Quyen saveQuyen(Quyen quyen) {
        return quyenRepository.save(quyen);
    }

    // Cập nhật quyền
    public Quyen updateQuyen(Quyen quyen) {
        return quyenRepository.save(quyen);
    }

    // Xóa quyền
    public void deleteQuyen(int id) {
        quyenRepository.deleteById(id);
    }
}
