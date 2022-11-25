package com.lucifer.lab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	
	
	//@Transient use for ignore JPA and will not store in database.
	@Transient
	private List<Rating> rating = new ArrayList<>();
	
	
	//other user's properties

	
}
