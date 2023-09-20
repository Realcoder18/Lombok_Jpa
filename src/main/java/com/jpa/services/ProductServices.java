package com.jpa.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jpa.models.Product;
import com.jpa.repositories.ProductRepository;
import com.jpa.responsewrappers.ProductResponsewrapper;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepository;
	
	ProductResponsewrapper prw=new ProductResponsewrapper();
	
	public ResponseEntity<?> getAllproduct()
	{
		
		Iterable<Product> data=productRepository.findAll();
		Iterator<Product> all_Products=data.iterator();
		if(all_Products.hasNext())
		{
			prw.setMessage("following product are found");
			prw.setData(all_Products);
			return new ResponseEntity<>(prw,HttpStatus.FOUND);
			
		}
		
		else {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"there is some producs are not found");
			
		}
		
	}
	
	
	public ResponseEntity<?> addAllproduct(Product product)
	{
		
		Product saved_product =productRepository.save(product);
		if(saved_product==null)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"there is some problem with server");
			
		}
		else {
		prw.setMessage("add all products");
		prw.setData(saved_product);
		return new ResponseEntity<>(prw,HttpStatus.FOUND);
		
		}
	}
	
	public ResponseEntity<?> getProductById(int id)
	{
		Product founded_product=productRepository.findById(id).orElseThrow(
				()->
				{
					throw new ResponseStatusException(HttpStatus.NOT_FOUND,"id does not exist");
					
				}
				
				
				);
			
		prw.setMessage("following product found in given id");
		prw.setData(founded_product);
		return new ResponseEntity<>(prw,HttpStatus.FOUND);
				
				
				
		
	}
	
	
}
