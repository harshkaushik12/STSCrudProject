package com.javaharsh.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaharsh.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailId(String email);
	public User findByEmailIdAndPassword(String email,String password);
	
}
