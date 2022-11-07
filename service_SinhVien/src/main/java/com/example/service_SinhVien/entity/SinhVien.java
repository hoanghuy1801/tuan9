package com.example.service_SinhVien.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sinhviens")
@Getter@Setter
public class SinhVien implements Serializable{
	@Id
	@Column(name = "sinhvienId", columnDefinition = "varchar(9)")
	private String id;
	private String name;

}
