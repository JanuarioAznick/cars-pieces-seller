package com.mycart.carspiecesseller.services;

import com.mycart.carspiecesseller.entities.User;

public interface AuthenticationService {

	User signInAndReturnJWT(User signInRequest);

}
