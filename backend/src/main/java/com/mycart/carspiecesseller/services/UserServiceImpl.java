package com.mycart.carspiecesseller.services;

import java.time.LocalDate;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.Role;
import com.mycart.carspiecesseller.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.CLIENT);
		user.setCreateTime(LocalDate.now());
		
		return userRepository.save(user);
	}
	
	@Override
	public Set<User> findByUsername (String username){
		
		return userRepository.findByUsername(username);
	}
	
	@Override
	@Transactional // only when exectute update/delete queries
	public void changeRole(String username, Role newRole) {
		
		 userRepository.updateUserRole(username, newRole);
		
	}

}
