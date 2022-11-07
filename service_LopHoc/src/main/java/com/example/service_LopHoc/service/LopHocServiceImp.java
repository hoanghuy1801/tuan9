package com.example.service_LopHoc.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.service_LopHoc.dto.LopHocDto;
import com.example.service_LopHoc.dto.SinhVienDto;
import com.example.service_LopHoc.entity.LopHoc;
import com.example.service_LopHoc.respository.LopHocRespsitory;

@Service
@Transactional
public class LopHocServiceImp implements LopHocService {
	@Autowired
	private LopHocRespsitory lopHocRespsitory;
	
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public LopHoc save(LopHoc lophoc) {
		// TODO Auto-generated method stub
		return lopHocRespsitory.save(lophoc);
	}

	@Override
	public LopHocDto getOne(String id) {
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		LopHoc lophoc = lopHocRespsitory.findById(id).get();

		String sinhvienId = lophoc.getSinhvienId();
		SinhVienDto sinhVienDto = restTemplate.exchange("http://localhost:4001/sinhviens".concat("/").concat(sinhvienId), 
				 HttpMethod.GET, 
				 entity,
				 SinhVienDto.class
				).getBody();
		LopHocDto lophocc= LopHocDto.builder()
			.id(lophoc.getId())
			.name(lophoc.getName())
			.toaNha(lophoc.getToaNha())
			.sinhvien(sinhVienDto).build();
		return lophocc;
	}

	@Override
	public List<LopHoc> getAll() {
		// TODO Auto-generated method stub
		return lopHocRespsitory.findAll();
	}

}
