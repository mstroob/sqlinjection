package com.database.demo.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaxxer.hikari.HikariDataSource;

public class UserRepositoryImpl {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private HikariDataSource dataSource;

}
