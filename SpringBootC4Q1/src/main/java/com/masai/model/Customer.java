package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull 
	@Size(min=3,max = 10 , message="customer should be size min 3 and max 10")
	private String customerName;
	@NotNull
	@Size(min=3,max = 15 , message="customer should be size min 3 and max 15")
	private String address;
	@NotNull
	@Min(value = 18, message="age should be max 18")
	private Integer age;
	@NotNull
	@Email(message = "mail should be proper format")
	private String email;
	@NotNull
	@Size(min = 10,max = 10,message="mobile no. should be size 10")
	private String mobile ;
	@NotNull
	@Size(min=3,max = 15 , message="customer should be size min 8 and max 15")
	private String password;
	
	public Customer(Integer customerId, String customerName, String address, Integer age, String email, String mobile,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", age=" + age + ", email=" + email + ", mobile=" + mobile + ", password=" + password + "]";
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
