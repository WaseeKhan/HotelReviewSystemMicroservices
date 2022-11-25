package com.lucifer.lab.service;

import com.lucifer.lab.entities.Rating;

import java.util.List;

public interface RatingService {

    //Create

    Rating createRating(Rating rating);
    //get all rating

    List<Rating> getAllRatings();

    //user wise ratings

    List<Rating> getRatingByUserId(String userId);


    //get all by hotel

    List<Rating> getRatingByHotelId(String hotelId);

}
