package com.example.demo.controller;

import com.example.demo.entity.Nhacungcap;
import com.example.demo.service.NhacungcapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/ncc")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class NhacungcapController {
    @Autowired
    private NhacungcapService nhacungcapService;

    @GetMapping("/getAll")
    public List<Nhacungcap> getAllNcc() {
        return nhacungcapService.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Nhacungcap> getNccById(@PathVariable Integer id) {
        Optional<Nhacungcap> nhacungcap = nhacungcapService.findById(id);
        return nhacungcap.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Nhacungcap createNcc(@RequestBody Nhacungcap nhacungcap) {
        return nhacungcapService.save(nhacungcap);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Nhacungcap> updateNcc(@PathVariable Integer id, @RequestBody Nhacungcap nhacungcap) {
        if (nhacungcapService.findById(id).isPresent()) {
            nhacungcap.setNcc_id(id);
            return ResponseEntity.ok(nhacungcapService.save(nhacungcap));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNcc(@PathVariable Integer id) {
        if (nhacungcapService.findById(id).isPresent()) {
            nhacungcapService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
