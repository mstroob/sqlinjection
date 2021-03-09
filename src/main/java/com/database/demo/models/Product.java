package com.database.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Product {
    private Long id;
    private String name;
    private float price;
 
    public Product() {
    }
 
	public Product(Long id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}
     
}