package com.example.service_SinhVien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServiceSinhVienApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSinhVienApplication.class, args);
	}

}
