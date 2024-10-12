package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Nhacungcap;
import org.springframework.stereotype.Repository;

@Repository
public interface NhacungcapRepository extends JpaRepository<Nhacungcap, Integer> {

}
