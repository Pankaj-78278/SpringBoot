package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.AccoountRepo;
import com.masai.exception.AccountException;
import com.masai.exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccoountRepo aRepo;

	@Override
	public Account openAccount(Account acc) throws AccountException {
		
		if(acc==null) {
			throw new AccountException("Account detail is empty");
		}
		return aRepo.save(acc);
		
		
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		
		Optional<Account> opt= aRepo.findById(accno);
				
				if(opt.isPresent()) {
					
					
					Account exist= opt.get();
					aRepo.delete(exist);
					
					return exist;
					
					
				}else
					throw new AccountException("AccountDoesnt exist...!!!!");
			}


	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
		
		Account act = aRepo.findById(accno).orElseThrow(()->new AccountException("Account not found.....!!!!"));
		 
		 act.setBalance(act.getBalance()+amount);
		 aRepo.save(act);
		 
		  return act;
	}

	@Override
	public Account withdrawAmount(int accno, Integer amount) throws AccountException, InsufficientFundException {
		
		Account act = aRepo.findById(accno).orElseThrow(()->new AccountException("Account not found.....!!!!"));
		
		if(act.getBalance()>amount) {
			act.setBalance(act.getBalance()-amount);
			aRepo.save(act);
		}
		else {
			throw new InsufficientFundException("Funds Unavailable...!!");
		}
		
		return act;
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException {
	
		return null;
	}

	

}
