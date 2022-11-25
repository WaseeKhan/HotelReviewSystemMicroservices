package com.lucifer.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.lab.entity.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
