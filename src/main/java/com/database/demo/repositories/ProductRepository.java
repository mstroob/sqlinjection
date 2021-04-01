package com.database.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
	
	@Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.description) LIKE %?1%")
	public List<Product> search(String keyword);
	

	public List<Product> searchBad(String keyword);


}