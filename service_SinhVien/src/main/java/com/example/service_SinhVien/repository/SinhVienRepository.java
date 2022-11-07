package com.example.service_SinhVien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service_SinhVien.entity.SinhVien;


@Repository
public interface SinhVienRepository extends  JpaRepository<SinhVien, String>{

}
