package com.database.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.demo.models.User;
	 
public interface UserRepository extends JpaRepository<User, Long> {

	
}