package com.mycart.carspiecesseller.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycart.carspiecesseller.dto.UserDTO;
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
	public Optional<User> findByUsername (String username){
		
		return userRepository.findByUsername(username);
	}
	
	@Override
	@Transactional // only when exectute update/delete queries
	public void changeRole(String username, Role newRole) {
		
		 userRepository.updateUserRole(username, newRole);
		
	}
	
	@Override
	public User saveClient(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.CLIENT);
		user.setCreateTime(LocalDate.now());
		
		return userRepository.save(user);
		
	}
	
	@Override
	public List<UserDTO> findAllClients() {
		
		  List<User> user = userRepository.findAllClients(Role.CLIENT);
		  return user.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Override
	public Optional<User> findUserById(Long id) {
		
		return userRepository.findById(id);
	}

}
