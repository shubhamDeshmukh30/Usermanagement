package com.neosoft.springbootpoc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springbootpoc.dao.Userrepo;
import com.neosoft.springbootpoc.entity.Address;
import com.neosoft.springbootpoc.entity.User;
import com.neosoft.springbootpoc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private Userrepo userrepo;

	@Override
	public String saveUser(User user) {
		Address address = new Address();
		userrepo.save(user);
		return "saved";
	}

	@Override
	public Optional<User> fetchUserById(int id) {
		return userrepo.findById(1);
	}

	@Override
	public List<User> fetchAllUserByCityName(String city) {

		return userrepo.findByCity(city);
	}

	@Override
	public String removeUser(int id) {
		userrepo.deleteById(id);
		return "user removed successfully";
	}

}
