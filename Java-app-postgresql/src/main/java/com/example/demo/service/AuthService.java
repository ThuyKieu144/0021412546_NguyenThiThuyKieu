package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public String login(LoginRequest loginRequest) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByEmail(loginRequest.getEmail());

        if (taiKhoan != null && taiKhoan.getTaikhoan_matkhau().equals(loginRequest.getPassword())) {
            if (taiKhoan.getQuyen().getQuyen_id() == 1) {
                return "Admin";
            } else {
                return "User";
            }
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

}
