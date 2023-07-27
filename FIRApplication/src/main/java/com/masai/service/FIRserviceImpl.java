package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DAO.FIRDAO;
import com.masai.model.CurrentSession;
import com.masai.model.FIR;

@Service
public class FIRserviceImpl implements FIRService {
	@Autowired
	private FIRDAO rfir;
	
	
	@Override
	public Map<String, Object> add_fir(FIR fir) {
		
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			CurrentSession c  = new CurrentSession();
			if (c.getId() >0) {
				rfir.save(fir);
				response.put("status", "Success");
				response.put("message", "Added Successfully");
		
			}else {
				response.put("status", "Failed");
				response.put("message", "Login First");
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.put("status", "Failed");
			response.put("message", "Something Went Wrong" +e);
		}
		return response;
	}

}
