package com.example.demo.controller;

import com.example.demo.dto.PasswordChangeRequest;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/taikhoan")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest request) {
        boolean result = taiKhoanService.changePassword(request.getEmail(), request.getCurrentPassword(), request.getNewPassword());
        if (result) {
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid current password or email");
        }
    }

    @GetMapping("/getAll")
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanService.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable Integer id) {
        Optional<TaiKhoan> taiKhoan = taiKhoanService.findById(id);
        return taiKhoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public TaiKhoan createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        return taiKhoanService.save(taiKhoan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaiKhoan> updateTaiKhoan(@PathVariable Integer id, @RequestBody TaiKhoan taiKhoan) {
        if (taiKhoanService.findById(id).isPresent()) {
            taiKhoan.setTaikhoan_id(id);
            return ResponseEntity.ok(taiKhoanService.save(taiKhoan));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTaiKhoan(@PathVariable Integer id) {
        if (taiKhoanService.findById(id).isPresent()) {
            taiKhoanService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/check-email")
    public boolean checkEmailExists(@RequestParam String email) {
        return taiKhoanService.emailExists(email);
    }

}

