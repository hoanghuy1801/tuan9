package com.example.service_LopHoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service_LopHoc.dto.LopHocDto;
import com.example.service_LopHoc.dto.SinhVienDto;
import com.example.service_LopHoc.entity.LopHoc;
import com.example.service_LopHoc.respository.LopHocRespsitory;
import com.example.service_LopHoc.service.LopHocService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;



@RestController

public class LopHocController {
	@Autowired
	private LopHocService lopHocService;
	
	@PostMapping("/lophocs")
	public LopHoc addLopHoc(@RequestBody LopHoc lopHoc) {
		return lopHocService.save(lopHoc);
	}
	@GetMapping("/lophocs")
	public List<LopHoc> getAll(){
		return lopHocService.getAll();
	}
	int count = 1;
	@GetMapping("lophocs/{id}")
	//@Retry(name = "passenger")
	//@CircuitBreaker(name = "passenger")
	@RateLimiter(name = "passenger")
	public LopHocDto getOne(@PathVariable String id) {		
		System.out.println("lan"+(count++));
		return lopHocService.getOne(id);
	}

}
