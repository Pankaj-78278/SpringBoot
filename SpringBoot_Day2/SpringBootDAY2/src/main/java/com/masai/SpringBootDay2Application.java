package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDay2Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootDay2Application.class, args);
	
		MyService obj=ctx.getBean("myService", MyService.class);
		obj.sayHello("PANKAJ RAI");
	
	}

}
