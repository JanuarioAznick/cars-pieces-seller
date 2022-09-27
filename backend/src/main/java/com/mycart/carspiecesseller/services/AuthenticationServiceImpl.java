package com.mycart.carspiecesseller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mycart.carspiecesseller.config.UserPrincipal;
import com.mycart.carspiecesseller.config.jwt.JwtProvider;
import com.mycart.carspiecesseller.entities.User;


@Service
public class AuthenticationServiceImpl implements AuthenticationService   {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User signInAndReturnJWT (User signInRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
		);
		
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		
		String jwt = jwtProvider.generateToken(userPrincipal);
		
		User signInUser = userPrincipal.getUser();
		
		signInUser.setToken(jwt);
			
		return signInUser;
	}
}
