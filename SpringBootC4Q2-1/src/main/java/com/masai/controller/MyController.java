package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AccountException;
import com.masai.exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.service.AccountService;

@RestController
public class MyController {
	
	@Autowired
	private AccountService aServ;
	
	@PostMapping("/accounts")
	public ResponseEntity<Account> registerAccountHandler(@Valid @RequestBody Account acc) throws AccountException{
		
		Account account=aServ.openAccount(acc);
		
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
	
	 @DeleteMapping("/accounts/{acnumber}")
	   public ResponseEntity<Account> DeleteAccountbyAccountHandler(@PathVariable("acnumber") Integer accNo) throws AccountException{
		  
		   Account act =  aServ.closeAccount(accNo);
		   
		   return new ResponseEntity<Account>(act,HttpStatus.OK);
		   
	   }


	 @GetMapping("/accounts/{acnumber}/{amount}")
	   public ResponseEntity<Account> DepositAccountHandler(@PathVariable("accnumber") Integer accno,@PathVariable("amount") Integer amount) throws AccountException{
		   
		   Account act = aServ.depositAmount(accno, amount);
		   
		   return new ResponseEntity<Account>(act,HttpStatus.OK);
		      
	   }
	 
	 @PutMapping("/accounts/{accno}/{amount}")
	 public ResponseEntity<Account> WithdrawlAmountHandler(@PathVariable("accno") Integer accno, @PathVariable("amount") Integer amount) throws AccountException, InsufficientFundException{
		 
		Account accoont =aServ.withdrawAmount(accno, amount);
		 return new ResponseEntity<Account>(accoont,HttpStatus.ACCEPTED);
		 
		 
		 
	 }
	 
	
	
	
}
