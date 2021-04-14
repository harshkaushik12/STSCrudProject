package com.javaharsh.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaharsh.crud.entity.Product;
import com.javaharsh.crud.entity.User;
import com.javaharsh.crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addProduct")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/products/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
//	@GetMapping("/products/{name}")
//	public Product findProductByName(@PathVariable String name) {
//		return service.getProductByName(name);
//	}
	
	
	@PutMapping("/update")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> deleteProduct(@PathVariable int id) {
			return service.deleteProduct(id);	
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
	  	  String tempEmailId=user.getEmailId();
	  	  if(tempEmailId != null && !"".equals(tempEmailId)) {
	  		 User userobj = service.fetchUserByEmailId(tempEmailId);
	  		 if(userobj != null) {
	  			 throw new Exception("User with "+tempEmailId+" is already exist");
	  		 }
	  	  }
	  	  User userObj=null;
		  userObj= service.registerUser(user);
		  return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmailId();
		String tempPass=user.getPassword();
		User userObj= null;
		if(tempEmail != null && tempPass != null) {
			userObj =service.fetchUserByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Bad Credential");
		}
		
		return userObj;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteUser(@PathVariable int id) {
			return service.deleteUser(id);	
	}

}
