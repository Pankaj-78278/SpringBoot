package com.masai.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDTO {
		@NotNull
	    private String mobileNumber;

	    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[#$@!%&?])[A-Za-z\\d#$@!%&?]{6,15}$",message = "password length must have atleast 6 characters of atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	    private String password;
}
