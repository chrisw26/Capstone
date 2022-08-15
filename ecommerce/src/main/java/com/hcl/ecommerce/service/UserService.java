package com.hcl.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.hcl.ecommerce.dto.AddressDto;
import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.entity.User;

public interface UserService {
	
	boolean addUser(UserDto userDto);
	
	boolean login(String email, String password);
	
	void updateUser(User user);
	
	void deleteUser(Integer id);
	
	User getUserByEmail(String email);

	User getUserByEmailAndPassword(String email, String password);

	User getUserById(Integer userId);

	
	
//	User loginUser(String username, String password);

//	User registerUser(UserDto userDto);
	
//	User getUser(Long id);

//	User updateUser(Long userId, String firstName);
//
//	void deleteUser(Long userId);
//
//	List<User> getAllUsers();
	




}
