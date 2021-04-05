package com.neosoft.springbootpoc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springbootpoc.customexception.InvalidId;
import com.neosoft.springbootpoc.customexception.cityNotBeNull;
import com.neosoft.springbootpoc.dao.Userrepo;
import com.neosoft.springbootpoc.entity.User;
import com.neosoft.springbootpoc.service.UserService;

@RestController
public class UserController {
	@Autowired
	private Userrepo repo;
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {

		String msg = service.saveUser(user);
		return msg;
	}

	@GetMapping("/fetch/{id}")
	public Optional<User> fetchUserById(@PathVariable int id) {
		if(id==0) {
			throw new InvalidId("Id should not be null");
		}
		return service.fetchUserById(id);

	}

	@GetMapping("/fetchByCityname/{city}")
	public List<User> fetchAllUserByCityName(@PathVariable String city) {
		if(city==null || city.isEmpty()) {
			throw new cityNotBeNull("city should not be null");
			
		}else {

		return service.fetchAllUserByCityName(city);

	}
	}

	@DeleteMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {

		String message = service.removeUser(id);
		return message;

	}
}
