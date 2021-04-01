package com.database.demo.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.database.demo.models.Product;
import com.zaxxer.hikari.HikariDataSource;

public class ProductRepositoryImpl {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private HikariDataSource dataSource;

	public List<Product> searchBad(String keyword){
		
		List<Product> list = new ArrayList<Product>();
		
	    String sql = "SELECT * FROM product where CONCAT(name,description) LIKE '%"+ keyword +"%';";
	    LOG.info("SQL entry {} ", sql);
	    try {
	        Connection c = dataSource.getConnection();
			ResultSet rs = c.createStatement().executeQuery(sql);
			
			while (rs.next()) {
		    	  int i = rs.getInt("id");
		    	  String str = rs.getString("name");
		    	  String desc = rs.getString("description");
		    	  float flt = rs.getFloat("price");
		    	  Product product = new Product(Long.valueOf(i), str, desc, flt);

		    	  list.add(product);
		    	}
		} catch (SQLException e) {
			LOG.info("SQL failed {} ", e.getMessage());
		}
	    
	    return list;
	}
	
}
