package com.mycart.carspiecesseller.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.carspiecesseller.config.UserPrincipal;
import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.Role;
import com.mycart.carspiecesseller.services.AuthenticationService;
import com.mycart.carspiecesseller.services.UserService;

@RestController
@RequestMapping("/api/user")//url padrao da api
public class UserController {

	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("login")//api/user/login
	public ResponseEntity<?> signIn(@RequestBody User user){
		//method from authservice for doing login
		return new ResponseEntity<> (authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
	}
	
	@PutMapping("change/{role}")//api/user/change/{role}
	public ResponseEntity<?> changeRole(@PathVariable Role role, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		
		userService.changeRole(userPrincipal.getUsername(), role);
		
		return ResponseEntity.ok(true);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<User> user = userService.findUserById(id);
		return ResponseEntity.ok(user);
	}

}
