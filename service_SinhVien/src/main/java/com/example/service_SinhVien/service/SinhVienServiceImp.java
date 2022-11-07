package com.example.service_SinhVien.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.service_SinhVien.entity.SinhVien;
import com.example.service_SinhVien.repository.SinhVienRepository;

@Service
@Transactional
public class SinhVienServiceImp  implements SinhVienService{
	private static final String REDIS_CACHE_VALUE = "sinhvien";
	@Autowired
	private SinhVienRepository sinhVienRepository;
	  @Autowired
	    private RedisTemplate template;
	
	@Override
	public SinhVien getOne(String id) {
		// TODO Auto-generated method stub
		SinhVien sinhVien =null;
		sinhVien=(SinhVien) template.opsForHash().get(REDIS_CACHE_VALUE, id);
		if(sinhVien != null)
			return sinhVien;
		
		sinhVien =sinhVienRepository.findById(id).get();
		if(sinhVien.getId()!=null)
			template.opsForHash().put(REDIS_CACHE_VALUE, sinhVien.getId(), sinhVien);
		
		return sinhVien;
	
	
	}

	@Override
	public List<SinhVien> getAll() {
		// TODO Auto-generated method stub
		return sinhVienRepository.findAll();
	}

	@Override
	public SinhVien add(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		return sinhVienRepository.save(sinhVien);
	}

}
