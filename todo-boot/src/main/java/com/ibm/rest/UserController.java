package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.User;
import com.ibm.pojo.Login;
import com.ibm.service.UserService;

@CrossOrigin()
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user", consumes = "application/json")
	public void addUser(@RequestBody User user) {
		int id = service.addUser(user);
		System.out.println("User added with Id: " + id);
	}
	
	@GetMapping(value = "/user/{userid}", produces = "application/json")
	public User getUser(@PathVariable int userid) {
		User user = service.getUser(userid);
		return user;
	}
	
	@GetMapping(value = "/users", produces = "application/json")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> validate(@RequestParam("email") String email, @RequestParam("passwd") String passwd) {
		Login login = new Login(email, passwd);
		try {
			User user = service.authenticate(login);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Email or Password", HttpStatus.NOT_FOUND);
		}
	}
}
