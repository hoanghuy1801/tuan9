package com.example.service_SinhVien.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service_SinhVien.entity.SinhVien;

@Service
public interface SinhVienService {
	SinhVien getOne(String id);
	List<SinhVien> getAll();
	SinhVien add(SinhVien sinhVien);

}
