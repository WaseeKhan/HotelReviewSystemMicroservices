package com.lucifer.lab.impl;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lucifer.lab.entity.Hotel;
import com.lucifer.lab.entity.Rating;
import com.lucifer.lab.entity.User;
import com.lucifer.lab.exception.ResourceNotFoundException;
import com.lucifer.lab.repository.UserRepository;
import com.lucifer.lab.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Class ArrayList = null;


	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

	//get single user
	@Override
	public User getUser(String userId) {
		
		 User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given ID not flound on server !! :  " +userId));
		 
		 //fetch rating for above user from rating service 
		 //http://localhost:8083/ratings/user/{userId}
		 
		 Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);
		 
		 
		 
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		 
		 List<Rating> ratingList = ratings.stream().map(rating->{
			//api call to hotel service to get hotel
			 
			ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			
			Hotel hotel = forEntity.getBody();
			
			logger.info("Response Status Code : {} ", forEntity.getStatusCode());
			
			rating.setHotel(hotel);
			 return rating;
		 }).collect(Collectors.toList());
		 
		 user.setRating(ratingList);
		 
		 return user;
		 
	}

}
