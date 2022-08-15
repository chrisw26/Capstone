package com.hcl.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@Override
	public synchronized boolean addUser(UserDto userDto) {
		if (getUserByEmail(userDto.getEmail()) != null) {
			return false;
		} else {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			mailSenderService.sendEmail(user.getEmail());
			userRepository.save(user);
			return true;
		}
	}
	
	@Override
	public boolean login(String email, String password) {
		if (getUserByEmailAndPassword(email, password) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void updateUser(User user) {
		
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	@Override
	public User getUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) return user.get();
		return null;
	}
	
//	@Override
//	public User registerUser(UserDto userDto) {
//		User user = new User();
//		
//		BeanUtils.copyProperties(userDto, user);
//		
//		mailSenderService.sendEmail(user.getEmail());
//		
//		return userRepository.save(user);
//	}
//	
//	@Override
//	public User loginUser(String email, String password) {
//		return userRepository.findByEmailAndPassword(email, password);
//	}
//	
//	@Override
//	public User getUser(Long id) {
//		Optional<User> user = userRepository.findById(id);
//		
//		if (user.isPresent())
//			return user.get();
//		
//		return null;
//	}
//
//	@Override
//	public User updateUser(Long userId, String firstName) {
//		User user = getUser(userId);
//		
//		user.setFirstName(firstName);
//		
//		return userRepository.save(user);
//	}
//
//	@Override
//	public void deleteUser(Long userId) {
//		userRepository.deleteById(userId);
//	}
//
//	@Override
//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}
//
//	@Override
//	public User getUserByEmail(String email, String password) {
//		//return userRepository.findByUsername(email);
//		return userRepository.findByEmailAndPassword(email, password);
//	}

}
