package com.masai.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NonNull
	@Pattern(regexp = "^[a-zA-Z]+$", message = "First Name must not contain numbers or special characters")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must not contain numbers or special characters")
	private String lastName;
	
	private String email;
	
	@NotNull
	@Size(min=10,max=10,message="Mobile number must have 10 digits ")
	private String mobileNumber;
	
	@Min(value = 12, message = "Age must be above 12 years")
	private Integer age;
	private String gender;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.")
	private String password;
	
	@JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blog= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comment= new ArrayList<>();
		
}
