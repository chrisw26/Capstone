package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.entity.User;

public interface UserService {

	boolean addUser(User user);
	
	User getUserByEmail(String email);

	User getUserById(Integer userId);

	void updateUser(User user);

	void deleteUser(Integer userId);

	List<User> getAllUsers();

	boolean login(String email, String password);

	User getUserByEmailAndPassword(String email, String password);

//	User loginUser(String username, String password);

//	User registerUser(UserDto userDto);

//	User getUser(Long id);

//	User updateUser(Long userId, String firstName);
//
//	void deleteUser(Long userId);
//
//	List<User> getAllUsers();

}
