package com.mycart.carspiecesseller.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.Role;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Set<User> findByUsername(String username);
	
	@Modifying
	@Query("update User set role :role where username = :username")
	void updateUserRole(@Param("username") String username, @Param("role") Role role);

}
