package com.hexaware.flightbackend.service;

import java.util.Collection;

import com.hexaware.flightbackend.bean.Login;
import com.hexaware.flightbackend.entity.User;
import com.hexaware.flightbackend.exception.UserException;

public interface UserService {
	
	 int createUser(User user) throws UserException;
		
	 User fetchUserById(int user_id) throws UserException;
	 
	 User validate(Login login);
	
	 public Collection<User> fetchAllUsers();

}
