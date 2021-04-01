package com.database.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@RequestMapping("/hello")
	public String index() {

		return "Hello Admin User";
	}

}
