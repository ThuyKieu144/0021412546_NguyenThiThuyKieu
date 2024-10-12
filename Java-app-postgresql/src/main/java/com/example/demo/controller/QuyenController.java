package com.example.demo.controller;

import com.example.demo.entity.Quyen;
import com.example.demo.service.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quyen")
public class QuyenController {

    @Autowired
    private QuyenService quyenService;

    @GetMapping
    public List<Quyen> getAllQuyens() {
        return quyenService.getAllQuyens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quyen> getQuyenById(@PathVariable int id) {
        return quyenService.getQuyenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quyen createQuyen(@RequestBody Quyen quyen) {
        return quyenService.saveQuyen(quyen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quyen> updateQuyen(@PathVariable int id, @RequestBody Quyen quyen) {
        return quyenService.getQuyenById(id)
                .map(existingQuyen -> {
                    quyen.setQuyen_id(id);
                    return ResponseEntity.ok(quyenService.updateQuyen(quyen));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuyen(@PathVariable int id) {
        quyenService.deleteQuyen(id);
        return ResponseEntity.noContent().build();
    }
}
