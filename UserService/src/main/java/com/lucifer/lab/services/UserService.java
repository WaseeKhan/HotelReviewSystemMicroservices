package com.lucifer.lab.services;

import java.util.List;

import com.lucifer.lab.entity.User;



public interface UserService {
	
	User saveUser(User user);
	
	
	List<User> getAllUser();
	
	User getUser(String userId);

	
	//to do
	//delete user
	//update user
}
