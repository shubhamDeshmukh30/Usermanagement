package com.neosoft.springbootpoc.service;

import java.util.List;
import java.util.Optional;

import com.neosoft.springbootpoc.entity.User;

public interface UserService {

	
	public String saveUser(User user);

	public Optional<User> fetchUserById(int id);

	public List<User> fetchAllUserByCityName(String city);

	public String removeUser(int id);

}
