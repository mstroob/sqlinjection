package com.database.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.demo.models.Users;
	 
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("SELECT p FROM Users p WHERE CONCAT(p.username) LIKE %?1%")
	public Users findByUsername(String username);
}