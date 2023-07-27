package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.EmployeRepo.FeedbackRepo;
import com.masai.exception.FeedbackException;
import com.masai.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private  FeedbackRepo fRepo;

	@Override
	public Feedback addFeedback(Feedback feedback) throws FeedbackException {
		Feedback feed=fRepo.save(feedback);
		
		return feed;
	}

	@Override
	public List<Feedback> viewFeedback(Feedback feedback) throws FeedbackException {
	List<Feedback> feeds=fRepo.findAll();
		
		if( feeds.size()==0) {
			throw new FeedbackException("Feedback is not Available");
		}else {
			return feeds;
		}
	}

	@Override
	public Feedback ViewfeedbackById(Integer feedBackId) throws FeedbackException {
		Optional<Feedback> feeds=fRepo.findById(feedBackId);
		if(feeds.isPresent()) {
			Feedback feedsback=feeds.get();
			return feedsback;
		}else {
			throw new FeedbackException("Feedback is not present as your FeedbackID :"+ feedBackId);
		}
		
		
	}

	@Override
	public Feedback updateFeedBackById(Feedback feedback) throws FeedbackException {
		
		Optional<Feedback> updateFeeds=fRepo.findById(feedback.getFeedBackId());
		
		if(updateFeeds.isPresent()) {
			Feedback feeds=fRepo.save(feedback);
			return feeds;
		}else {
			throw new FeedbackException("Feedback Id is not Present :"+ updateFeeds);
		}
	}

	@Override
	public Feedback deleteFeedback(Integer feedBackId) throws FeedbackException {
		Feedback del=fRepo.findById(feedBackId).orElseThrow(()-> new FeedbackException("Feedback is not present"));
		
		fRepo.delete(del);
		return del;
	}

	
	
}	
	
	
	
	
	
	
	
//	@Override
//	public Feedback registerEmployee(Feedback emp) throws EmployeeException {
//		
//		Feedback saveEmpl=eRepo.save(emp);
//		return saveEmpl;		
//		
//		
//	}
//
//	@Override
//	public Feedback getEmployeeById(Integer empId) throws EmployeeException {
//		Optional<Feedback> empl=eRepo.findById(empId);
//		if(empl.isPresent()) {
//			Feedback emplo= empl.get();
//			
//			return emplo;
//					
//		}else {
//			throw new EmployeeException("Employee id not present");
//		}
//	}
//
//	@Override
//	public List<Feedback> getAllEmployeeDetails() throws EmployeeException {
//		List<Feedback> empl=eRepo.findAll();
//		if(empl.size()==0) {
//			throw new EmployeeException("Employee not hterer");
//			
//		}else {
//			return empl;
//		}
//	}
//
//	@Override
//	public Feedback deleteEmployeeById(Integer empId) throws EmployeeException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Feedback loginEmployee(String email, String password) throws EmployeeException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Feedback> getEmployeeDetailsByAddress(String address) throws EmployeeException {
//	
//		List<Feedback> res=eRepo.findByAddress(address);
//		if(res!=null) {
//			return res;
//		}else {
//			throw new EmployeeException("Employee not found");
//		}
//		
//			
//	}
//
//	@Override
//	public Feedback updateEmployee(Feedback emp) throws EmployeeException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
//		
//		String name=eRepo.findNameById(empId);
//		
//		if(name!=null) {
//			return name;
//		}else {
//			throw new EmployeeException("Employee not find out by id :"+ empId);
//		}
//		
//	}
//
//	@Override
//	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee(Integer empId) throws EmployeeException {
//		List<EmployeeDTO> emp=eRepo.findByNameAdress(empId);
//		if(emp!=null) {
//			return emp;
//		}else {
//			throw new EmployeeException("Employee not found By id"+ empId);
//		}
//		
//	}
//
//	@Override
//	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
//		
//		List<EmployeeDTO> empDto=eRepo.getNameAddressSalary();
//		
//		if(empDto!=null) {
//			return empDto;
//		}else {
//			throw new EmployeeException("EMployee not find by Id:");
//		}
//		
//	}


