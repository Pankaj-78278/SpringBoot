package com.masai.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Email(message= "Invalide email aaddres")
	private String email;

    @NotNull
    @Size(min=1,max=20)
    @Pattern(regexp = "[a-zA-Z]+", message = "First name not contain numbers & special characters")
    private String firstName;

    @NotNull
    @Size(min=1,max=20)
    @Pattern(regexp = "[a-zA-Z]+", message = "Last name not contain numbers & special characters")
    private String lastName;

    @NotNull
    @Size(min=10, max=10)
    @Pattern(regexp = "[0-9]+", message = "Mobile number must have 10 digits")
    private String mobileNumber;

    @NotNull
    @Size(min = 6, max = 12)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password should be alphanumeric and must contain special character and digit.")
    private String password;
  
    @NotNull
    @Past
    private LocalDate dateOfBirth;
}
