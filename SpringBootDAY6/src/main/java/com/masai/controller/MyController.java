package com.masai.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.exception.FeedbackException;
import com.masai.model.Feedback;
import com.masai.model.EmployeeDTO;
import com.masai.service.FeedbackService;

@RestController
public class MyController {
	
	@Autowired
	private FeedbackService eServ;

	
	@PostMapping("/feedbacks")
	public ResponseEntity<Feedback> saveEmployeeHandler(@Valid @RequestBody Feedback feedback) throws  FeedbackException{
		
		Feedback empl=eServ.addFeedback(feedback);
		
		return new ResponseEntity<Feedback>(empl,HttpStatus.CREATED);
	}
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedback(Feedback feedback) throws FeedbackException{
		
		List<Feedback> feeds= eServ.viewFeedback(feedback);
		return new ResponseEntity<List<Feedback>>(feeds,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/feedbacks/{id}")
	public ResponseEntity<Feedback> viewFeedbackById (@PathVariable("id")  Integer feedBackId) throws FeedbackException{
		
		Feedback feedsbak=eServ.ViewfeedbackById(feedBackId);
		
		return new ResponseEntity<Feedback>(feedsbak,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/feedbacks")
	public ResponseEntity<Feedback> updateFeedbackById(@RequestBody Feedback feedback) throws FeedbackException{
		Feedback result=eServ.updateFeedBackById(feedback);
		
		return new ResponseEntity<Feedback>(result,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/feedbacks/{id}")
	public ResponseEntity<Feedback> deleteFeedbackById(@PathVariable("id") Integer feedback) throws FeedbackException{
		Feedback deletefeeds=eServ.deleteFeedback(feedback);
	
		return new ResponseEntity<Feedback>(deletefeeds,HttpStatus.OK);
		
	}
	
	
//	
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Feedback> getEmpployeeIdHandler(@PathVariable("id") Integer empId) throws EmployeeException{
//		
//		Feedback empl=eServ.getEmployeeById(empId);
//		
//		return new ResponseEntity<Feedback>(empl,HttpStatus.ACCEPTED);	
//	}
//	
//	@GetMapping("/employees")
//	public ResponseEntity<List<Feedback>> getAllEmployeeHandler(Feedback employee) throws EmployeeException{
//		List<Feedback> empl=eServ.getAllEmployeeDetails();
//		
//		return new ResponseEntity<List<Feedback>>(empl,HttpStatus.ACCEPTED);
//	}
//	
//	@GetMapping("/employeesadd/{address}")
//	public ResponseEntity<List<Feedback>> getDetailbyAdressHandler(@PathVariable("address") String Address) throws EmployeeException{
//		
//		List<Feedback> res=eServ.getEmployeeDetailsByAddress(Address);
//		
//		return new ResponseEntity<List<Feedback>>(res,HttpStatus.ACCEPTED);
//	}
//	
//	@GetMapping("/employeesid/{id}")
//	public ResponseEntity<String> getNameAddressByIdHandler(@PathVariable("id") Integer empId) throws EmployeeException{
//		
//		String result=eServ.getNameAndAddressOfEmplyeeById(empId);
//		
//		return new ResponseEntity<String>(result, HttpStatus.OK);
//	}
//	
//	@GetMapping("/empidemployees/{id}")
//	public ResponseEntity<List<EmployeeDTO>> getNameAddressSalaryByHandler(@PathVariable("id") Integer empId) throws EmployeeException{
//		
//		List<EmployeeDTO> res= eServ.getNameAddressSalaryOfAllEmployee(empId);
//		return new ResponseEntity<List<EmployeeDTO>>(res,HttpStatus.ACCEPTED);
//	}
//	
//	@GetMapping("/getsemployees")
//	public ResponseEntity<List<EmployeeDTO>> numGetNameAddressHandler(EmployeeDTO emp) throws EmployeeException{
//		
//		List<EmployeeDTO> empl=eServ.getNameAddressSalaryOfAllEmployee();
//		
//		return new ResponseEntity<List<EmployeeDTO>>(empl,HttpStatus.OK);
//	}
//	
	
			
}
