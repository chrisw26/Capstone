package com.hcl.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Void> addUser(@RequestBody UserDto userDto) {
		boolean flag = userService.addUser(userDto);
		if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Void> loginUser(@RequestParam String email, @RequestParam String password) {
		boolean flag = userService.login(email, password);
		if (!flag) return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


//	@PostMapping("/register")
//	public User registerUser(@RequestBody UserDto userDto) {
//		return userService.registerUser(userDto);
//	}
	
//	@GetMapping("/login")
//	public User loginUser(@RequestParam String email, @RequestParam String password) {
//		return userService.loginUser(email, password);
//	}
	
//	@GetMapping("/getUser/{userId}")
//	public User getUser(@PathVariable Long userId) {
//		log.info("inside of getUser " + userId);
//		return userService.getUser(userId);
//	}
	
//	@PostMapping("/updateUser/{userId}")
//	public User updateUser(@PathVariable Long userId, @RequestParam String firstName) {
//		return userService.updateUser(userId, firstName);
//	}
//
//	@DeleteMapping("/deleteUser/{userId}")
//	public String deleteUser(@PathVariable Long userId) {
//		try {
//			userService.deleteUser(userId);
//		} catch (Exception e) {
//			return "Failed";
//		}
//		
//		return "Success";
//	}
//
//	@GetMapping("/all")
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
	
//	@GetMapping("/byEmail")
//	public User getUserByEmail(@RequestParam String email) {
//		return userService.getUserByEmail(email);
//	}
//	
//	@GetMapping("/byEmailAndPassword")
//	public User getUserByEmail(@RequestParam String email, @RequestParam String password) {
//		return userService.getUserByEmailAndPassword(email, password);
//	}

}
