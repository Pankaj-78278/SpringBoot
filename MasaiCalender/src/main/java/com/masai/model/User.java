package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
		@Id
		@Email
		@GeneratedValue(strategy = GenerationType.AUTO)
		private String email;
	    
		@NotNull
		private Integer userId;
	    @NotNull
	    @Pattern(regexp = "^[a-zA-Z]*$")
	    private String firstName;
	    
	    @NotNull
	    @Pattern(regexp = "^[a-zA-Z]*$")
	    private String lastName;
	    
	    @NotNull
	    @Pattern(regexp = "^[0-9]{10}$")
	    private String mobileNumber;
	    
	    @NotNull
	    @Size(min = 6, max = 12)
	    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).*$")
	    private String password;
	    
	    @Past
	    private LocalDate dateOfBirth;
	    
	    @OneToMany(cascade = CascadeType.ALL)
		private List<Event> events = new ArrayList<>();

	 
}


