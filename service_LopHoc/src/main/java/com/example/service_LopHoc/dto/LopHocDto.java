package com.example.service_LopHoc.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LopHocDto {
	private String id;
	private String name;
	private String toaNha;
	
	private SinhVienDto sinhvien;

}
