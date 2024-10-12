package com.example.demo.controller;

import com.example.demo.entity.CTDonHang;
import com.example.demo.entity.DonHang;
import com.example.demo.service.CTDonHangService;
import com.example.demo.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})

public class DonHangController {

    @Autowired
    private DonHangService donHangService;


    @GetMapping("/getAll")
    public List<DonHang> getAllDonHangs() {
        return donHangService.getAllDonHangs();
    }

    @GetMapping("/{id}")
    public DonHang getDonHangById(@PathVariable Integer id) {
        return donHangService.getDonHangById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<DonHang> createOrder(@RequestBody DonHang donHang) {
        DonHang newDonHang = donHangService.createOrder(donHang);
        return new ResponseEntity<>(newDonHang, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/addDetails")
    public ResponseEntity<Void> addOrderDetails(@PathVariable("id") Integer orderId, @RequestBody List<CTDonHang> details) {
        donHangService.addOrderDetails(orderId, details);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/updateTrangThai/{id}/{trangThaiId}")
    public ResponseEntity<?> updateTrangThai(@PathVariable Integer id, @PathVariable Integer trangThaiId) {
        DonHang updatedDonHang = donHangService.updateTrangThai(id, trangThaiId);
        if (updatedDonHang != null) {
            return ResponseEntity.ok(updatedDonHang);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Đơn hàng hoặc trạng thái không tồn tại.");
        }
    }

    @PostMapping
    public DonHang createDonHang(@RequestBody DonHang donHang) {
        return donHangService.saveDonHang(donHang);
    }

    @PutMapping("/{id}")
    public DonHang updateDonHang(@PathVariable Integer id, @RequestBody DonHang donHang) {
        donHang.setDh_id(id);
        return donHangService.saveDonHang(donHang);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<DonHang>> getOrderHistoryByEmail(@PathVariable String email) {
        List<DonHang> orderHistory = donHangService.getOrdersByCustomerEmail(email);
        if (orderHistory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Return a 404 if no orders found
        }
        return ResponseEntity.ok(orderHistory);
    }

//    @GetMapping("/{orderId}/products")
//    public ResponseEntity<List<CTDonHang>> getOrderProducts(@PathVariable Integer orderId) {
//        List<CTDonHang> orderProducts = donHangService.getOrderProducts(orderId);
//        if (orderProducts.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(orderProducts);
//    }


}

