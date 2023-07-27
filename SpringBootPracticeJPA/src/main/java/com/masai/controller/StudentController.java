package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController

public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	
	
//	@PostMapping("/students")
//	public ResponseEntity<String> registerStudent(@RequestBody Student student){
//	
//		Student	savedStudent=sService.registerStudent(student);
//		
//		return new ResponseEntity<String>(student.toString(),HttpStatus.CREATED);
//	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student){
	
		Student	savedStudent=sService.registerStudent(student);
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable("roll") Integer roll) throws StudentException {
		
	Student student=sService.getStudentByRoll(roll);
	
	return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
