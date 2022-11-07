package com.example.service_LopHoc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service_LopHoc.dto.LopHocDto;
import com.example.service_LopHoc.entity.LopHoc;




public interface LopHocService {
	LopHoc save(LopHoc lophoc);
	LopHocDto getOne(String id);
	List<LopHoc> getAll();


}
