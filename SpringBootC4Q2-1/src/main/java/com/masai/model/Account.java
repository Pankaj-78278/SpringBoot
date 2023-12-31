package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer accountNo; 
	@NotNull
	private String accountHolderName ;
	@NotNull
	private String address; 
	@NotNull
	@Email
	private String email; 
	@NotNull
	@Size(max  = 5, message = "Opening balance should be minimum 10000 ")
	private Integer balance;
	@NotNull
	@Size(min = 10,max = 10,message="mobile no. should be size 10")
	private String mobile;
	
	public Account(Integer accountNo, String accountHolderName, String address, String email, Integer balance,
			String mobile) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.address = address;
		this.email = email;
		this.balance = balance;
		this.mobile = mobile;
	}
	
	public Account() {
		super();
	}
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + ", address=" + address
				+ ", email=" + email + ", balance=" + balance + ", mobile=" + mobile + "]";
	}
	
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
