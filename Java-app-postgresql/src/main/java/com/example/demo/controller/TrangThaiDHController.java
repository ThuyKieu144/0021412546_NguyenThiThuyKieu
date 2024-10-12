package com.example.demo.controller;

import com.example.demo.entity.TrangThaiDH;
import com.example.demo.service.TrangThaiDHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ttDH")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class TrangThaiDHController {
    @Autowired
    private TrangThaiDHService trangThaiDHService;

    @GetMapping
    public List<TrangThaiDH> getAllTrangThaiDH() {
        return trangThaiDHService.getAllTrangThaiDH();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrangThaiDH> getTrangThaiDHById(@PathVariable int id) {
        Optional<TrangThaiDH> trangThaiDH = trangThaiDHService.getTrangThaiDHById(id);
        return trangThaiDH.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrangThaiDH createTrangThaiDH(@RequestBody TrangThaiDH trangThaiDH) {
        return trangThaiDHService.createTrangThaiDH(trangThaiDH);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrangThaiDH> updateTrangThaiDH(@PathVariable int id, @RequestBody TrangThaiDH trangThaiDH) {
        TrangThaiDH updated = trangThaiDHService.updateTrangThaiDH(id, trangThaiDH);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteTrangThaiDH(@PathVariable Integer id) {
        trangThaiDHService.deleteTrangThaiDH(id);
    }
}
