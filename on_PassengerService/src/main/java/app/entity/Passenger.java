package app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passengers")
@Getter@Setter

public class Passenger implements Serializable{
	@Id
	@Column(name = "passengerId", columnDefinition = "varchar(9)")
	private String id;
	private String name;
	private String address;
}
