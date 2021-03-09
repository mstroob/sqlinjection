package com.database.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
	 
@ComponentScan (basePackages ="com.database.demo")
@SpringBootApplication
public class SqlInjection {
	    public static void main(String[] args) {
	        SpringApplication.run(SqlInjection.class, args);
	    }
	}