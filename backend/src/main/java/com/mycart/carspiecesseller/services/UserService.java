package com.mycart.carspiecesseller.services;

import java.util.Set;

import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.Role;

public interface UserService {

	User saveUser(User user);

	Set<User> findByUsername(String username);

	void changeRole(String username, Role newRole);

}
