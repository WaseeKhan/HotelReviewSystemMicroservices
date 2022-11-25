package com.lucifer.lab.impl;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucifer.lab.entity.User;
import com.lucifer.lab.exception.ResourceNotFoundException;
import com.lucifer.lab.repository.UserRepository;
import com.lucifer.lab.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		//generate unique user id
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	
	}

	@Override
	public User getUser(String userId) {
		
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given ID not flound on server !! :  " +userId));
	}

}
