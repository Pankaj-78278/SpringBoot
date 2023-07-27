package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentRepo;


@Service
public class StudentDaoImpl implements StudentService {
	
	@Autowired
	private StudentRepo sRepo;
	
	@Override
	public Student registerStudent(Student student) {
		
		Student savedStd=sRepo.save(student);
		
		return savedStd;
	}

	
	@Override
	
	public Student getStudentByRoll(Integer roll) throws StudentException  {
		Optional<Student> opt=sRepo.findById(roll);
		if(opt.isPresent()) {
			Student student=opt.get();
			
			return student;
		}else {
			throw new StudentException("Student does not exist"+ roll);
		}
		
	}

}
