package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must not contain numbers or special characters")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must not contain numbers or special characters")
    private String lastName;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}",message="Mobile number length must be 10 digits [0-9]")
    private String mobileNumber;

    @NotNull
    private String address;

    @NotNull
    @Size(min=12,message="Age must be above 12 year")
    private Integer age;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    @Pattern(regexp = "^(male|female)$", message = "Gender should be either male or female")
    private String gender;

    @NotNull
    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[#$@!%&?])[A-Za-z\\d#$@!%&?]{6,15}$",message = "password length must contain atleast 6 characters of atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;

    @NotNull
    private Integer budget;
    
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
}
