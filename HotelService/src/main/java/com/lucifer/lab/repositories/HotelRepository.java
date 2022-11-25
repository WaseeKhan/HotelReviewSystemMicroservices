package com.lucifer.lab.repositories;

import com.lucifer.lab.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
