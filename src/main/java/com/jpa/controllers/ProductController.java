package com.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.models.Product;
import com.jpa.services.ProductServices;

import jakarta.validation.Valid;

@RequestMapping("/products")
@RestController
public class ProductController {

	@Autowired
	ProductServices productServices;
	
	@GetMapping("")
	public ResponseEntity<?> getAllproduct()
	{
	
		return productServices.getAllproduct();
	}
	
	@PostMapping("")
	public ResponseEntity<?> addAllproduct( @RequestBody @Valid Product product)
	{
	 
		return productServices.addAllproduct(product);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById( @PathVariable  int id)
	
	{
		return productServices.getProductById(id);
	}
	
	
}
