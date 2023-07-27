package com.masai.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	
	@Pattern(regexp = "^[a-zA-Z]*$",message= "First name must not contain or special charachter")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]*$",message= "Last name must not contain or special charachter")
	private String lastName;
	
	@Size(min=10,max=10,message= "mobile no should be 10 digit" )
	private String mobileNumber;
	
	private String address;
	
	@Size(min=12,message="Age must be aabove 12 year")
	private Integer age; 
	
	@NotNull(message = "Gender is required")
	@Pattern(regexp = "^(male|female)$", message = "Gender should be either male or female")
	private String gender;
	
	@Pattern(regexp = "((?=,*[a-z])(?=,*[A-Z])(?=,*[!@#$%^&*])(?=,*[0-9])),{6,12}$",message= "Password name must not contain or special charachter")
	private String password;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<FIR> fir= new ArrayList<>();
	
}