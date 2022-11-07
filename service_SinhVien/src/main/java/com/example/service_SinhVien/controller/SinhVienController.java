package com.example.service_SinhVien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service_SinhVien.entity.SinhVien;
import com.example.service_SinhVien.service.SinhVienService;



@RestController
@RequestMapping("/sinhviens")
public class SinhVienController {
	
	@Autowired
	private SinhVienService sinhVienService;
	@GetMapping
	public List<SinhVien> findAll() {
		
		
		return sinhVienService.getAll();
	}
	
	@GetMapping("/{id}")
	public SinhVien getsinhvien(@PathVariable String id) {
		System.out.println(id);
		return sinhVienService.getOne(id);
	}

	@PostMapping()
	public SinhVien save(@RequestBody SinhVien sinhVien) {
		return sinhVienService.add(sinhVien);
	}

}
