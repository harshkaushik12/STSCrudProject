package com.javaharsh.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaharsh.crud.entity.Product;
import com.javaharsh.crud.entity.User;
import com.javaharsh.crud.repository.ProductRepository;
import com.javaharsh.crud.repository.UserRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private UserRepository repoUser;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Product> deleteProduct(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
		
		
	}
	
	public User registerUser(User user) {
		return repoUser.save(user);
		
	}
	
	public User fetchUserByEmailId(String email) {
		return repoUser.findByEmailId(email);
	}
	
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repoUser.findByEmailIdAndPassword(email,password);
	}
	
	public String deleteUser(int id) {
		repoUser.deleteById(id);
		return "deleted";
		
	}
	
	
	
	
	
	
	

}
