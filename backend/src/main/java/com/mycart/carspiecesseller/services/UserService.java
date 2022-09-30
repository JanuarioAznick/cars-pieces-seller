package com.mycart.carspiecesseller.services;

import java.util.List;
import java.util.Optional;

import com.mycart.carspiecesseller.dto.UserDTO;
import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.Role;

public interface UserService {

	User saveUser(User user);

	Optional<User> findByUsername(String username);
	
	List<UserDTO> findAllClients();
//	
	User saveClient(User user);

	void changeRole(String username, Role newRole);

	Optional<User> findUserById(Long id);

}
