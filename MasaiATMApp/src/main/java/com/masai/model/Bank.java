package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	private String name;
	private String headOfficeAt;
}
