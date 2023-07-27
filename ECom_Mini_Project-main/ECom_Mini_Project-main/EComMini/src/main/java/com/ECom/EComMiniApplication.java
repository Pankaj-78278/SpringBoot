package com.ECom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ECom")
public class EComMiniApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComMiniApplication.class, args);
    }

}
