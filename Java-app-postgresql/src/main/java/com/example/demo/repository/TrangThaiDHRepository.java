package com.example.demo.repository;

import com.example.demo.entity.TrangThaiDH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiDHRepository extends JpaRepository<TrangThaiDH, Integer> {
}
