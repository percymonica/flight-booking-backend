package com.hexaware.flightbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.flightbackend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String username,String password);

}
