package com.example.service_LopHoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lophocs")
@Getter@Setter
public class LopHoc {
	@Id
	@Column(name = "LopHocId",columnDefinition = "varchar(9)")
	private String id;
	private String name;
	private String toaNha;
	
	private String sinhvienId;

}
