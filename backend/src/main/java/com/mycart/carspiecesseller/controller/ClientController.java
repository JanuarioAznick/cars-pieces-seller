package com.mycart.carspiecesseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.services.UserService;

@RestController
@RequestMapping("/api/client")//url padrao
public class ClientController {
	
	@Autowired
	private UserService userService;
	
	
//	/*
//	 * Método de cadastro de clientes
//	 */
	@PostMapping("sign-up")//api/client/sign-up
	public ResponseEntity<?> saveClient (@RequestBody User user){
		
		
		if(userService.findByUsername(user.getUsername()).isPresent()) {
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}

		return new ResponseEntity<>(userService.saveClient(user), HttpStatus.CREATED);
	}
	
	
	@GetMapping("findall")//api/client/findall
	public ResponseEntity<?> findAllClients(){
		
		return new ResponseEntity<>(userService.findAllClients(), HttpStatus.OK);
	}
	
	
	

}
