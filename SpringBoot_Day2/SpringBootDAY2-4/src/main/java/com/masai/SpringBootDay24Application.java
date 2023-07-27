package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.masai.Controller.MyService;

@SpringBootApplication
public class SpringBootDay24Application {

	public static void main(String[] args) {
	SpringApplication.run(SpringBootDay24Application.class, args);
//		MyService obj=ctx.getBean("myService",MyService.class);
//		
//		obj.sayHello("Amit");
	
	}

}
