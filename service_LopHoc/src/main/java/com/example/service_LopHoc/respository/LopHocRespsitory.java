package com.example.service_LopHoc.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service_LopHoc.entity.LopHoc;


@Repository
public interface LopHocRespsitory extends JpaRepository<LopHoc, String> {

}
