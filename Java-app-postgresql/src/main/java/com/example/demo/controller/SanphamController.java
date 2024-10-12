package com.example.demo.controller;

import com.example.demo.entity.Sanpham;
import com.example.demo.service.SanphamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@RequestMapping("/sanpham")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class SanphamController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private SanphamService sanphamService;

    @GetMapping("/getAll")
    public List<Sanpham> getAllSanpham() {
        return sanphamService.getAllSanpham();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Sanpham> getSanphamById(@PathVariable Integer id) {
        Optional<Sanpham> sanpham = sanphamService.getSanphamById(id);
        if (sanpham != null) {
            return sanpham.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public Sanpham createSanpham(@RequestBody Sanpham sanpham) {
        return sanphamService.saveSanpham(sanpham);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sanpham> updateSanpham(@PathVariable Integer id, @RequestBody Sanpham sanpham) {
        if (sanphamService.getSanphamById(id).isPresent()) {
            sanpham.setSp_id(id);
            return ResponseEntity.ok(sanphamService.saveSanpham(sanpham));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSanpham(@PathVariable Integer id) {
        sanphamService.deleteSanpham(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Log file details
            System.out.println("Uploading file: " + file.getOriginalFilename());
            System.out.println("File size: " + file.getSize());

            // Ensure upload directory exists
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
                System.out.println("Created upload directory: " + uploadPath);
            }

            // Save file
            String originalFilename = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(originalFilename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Return the file URI
            String fileDownloadUri = "http://localhost:8080/sanpham/uploads/" + originalFilename;
            Map<String, String> response = new HashMap<>();
            response.put("fileDownloadUri", fileDownloadUri);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            System.out.println("Error uploading file: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "K thể tải lên hình ảnh: " + e.getMessage()));
        }
    }


//    @PostMapping("/upload")
//    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
//        Map<String, String> response = new HashMap<>();
//        try {
//            // Ensure upload directory exists
//            Path uploadPath = Paths.get(uploadDir);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            // Save the file
//            String originalFilename = file.getOriginalFilename();
//            Path filePath = uploadPath.resolve(originalFilename);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Return the file URL
//            String fileDownloadUri = "http://localhost:8080/sanpham/uploads/" + originalFilename;
//            response.put("fileDownloadUri", fileDownloadUri);
//
//            return ResponseEntity.ok(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//            response.put("error", "Không thể tải lên hình ảnh: " + e.getMessage());
//            return ResponseEntity.status(500).body(response);
//        }
//    }





    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // Determine content type
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

}


