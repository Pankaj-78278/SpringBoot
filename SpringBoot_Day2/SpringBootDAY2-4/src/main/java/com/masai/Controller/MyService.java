package com.masai.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Employee;

@RestController
@RequestMapping("/employeeapp")
public class MyService { //class called "root resource"
	
		@RequestMapping("/service/{name}")
		@ResponseBody

		public String  sayHello(@PathVariable("name") String name){//method called "resource"
		return "Welcome"+ name;
//			return "welcome"+" "+"Ram";
//		http://localhost:8888/employeeapp/service/Amit
		
		}
//		@GetMapping(value="/emp/{id}/{n}/{a}/{s}")
		@GetMapping(value="/{id}/{n}/{a}/{s}")
		public Employee getEmployee(@PathVariable("id")Integer Id,
									@PathVariable("n") String name,
									@PathVariable("a") String address,
									@PathVariable("s") Integer salary) {
			Employee employee =new Employee();
			employee.setEmpId(Id);
			employee.setName(name);
			employee.setAddress(address);
			employee.setSalary(salary);
			
			return employee;
		}
//		http://localhost:8888/employeeapp/10/Ram/Faridabad/500
//		http://localhost:8888/employeeapp/emp/10/Ram/Faridabad/500
		
		@GetMapping(value = "/employees")
		public List<Employee> getAllStudents() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(10, "Ram","Haryana",850));
		employees.add(new Employee(12, "Ramesh","Punjab",650));
		employees.add(new Employee(13, "Ravi","Himachal" ,750));
		employees.add(new Employee(14, "amit","Gujarat" ,950));
		return employees;
		}
//		http://localhost:8888/employeeapp/employees
}
