package com.lucifer.lab.services;

import com.lucifer.lab.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //get all
    List<Hotel> getAllHotel();

    //get single
    Hotel getHotel(String id);
}
