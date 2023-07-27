package com.masai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accId;
	private String accNo;
	private String IFSC;
	private LocalDateTime accOpen;
	private Integer balance;
	
	@JsonIgnore
	@ManyToOne 
	private Bank bank;
	
	@JsonIgnore
	@ManyToOne 
	private User user;
	
}
