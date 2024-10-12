package com.example.demo.service;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public List<TaiKhoan> findAll() {
        return taiKhoanRepository.findAll();
    }

    public Optional<TaiKhoan> findById(Integer id) {
        return taiKhoanRepository.findById(id);
    }

    public TaiKhoan save(TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    public void deleteById(Integer id) {
        taiKhoanRepository.deleteById(id);
    }

    public long countAccounts() {
        return taiKhoanRepository.count();
    }

    public boolean emailExists(String email) {
        return taiKhoanRepository.existsByTaiKhoanEmail(email);
    }

    public boolean changePassword(String email, String currentPassword, String newPassword) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByEmail(email);
        if (taiKhoan != null) {
            System.out.println("Tài khoản tìm thấy: " + taiKhoan.getTaikhoan_ten());
            // Kiểm tra mật khẩu hiện tại có khớp không
            if (taiKhoan.getTaikhoan_matkhau().equals(currentPassword)) {
                System.out.println("Mật khẩu hiện tại đúng. Đang thay đổi mật khẩu...");
                // Thay đổi mật khẩu mới
                taiKhoan.setTaikhoan_matkhau(newPassword);
                taiKhoanRepository.save(taiKhoan);
                return true;
            } else {
                System.out.println("Mật khẩu hiện tại không đúng.");
            }
        } else {
            System.out.println("Không tìm thấy tài khoản với email: " + email);
        }
        return false;
    }

}
