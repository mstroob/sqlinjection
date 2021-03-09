package com.database.demo.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.database.demo.models.Product;
import com.database.demo.repositories.ProductRepository;
 
@Service
@Transactional
public class ProductService {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
    
    public List<Product> listAllBad(String keyword) {
    	LOG.info("received bad request {} ", keyword);
        if (keyword != null) {
            return repo.searchBad(keyword);
        }
        return repo.findAll();
    }
}