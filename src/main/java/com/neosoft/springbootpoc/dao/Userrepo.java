package com.neosoft.springbootpoc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.neosoft.springbootpoc.entity.User;

public interface Userrepo extends MongoRepository<User, Integer>{

	

	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);

}
