package com.mycart.carspiecesseller.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mycart.carspiecesseller.entities.enums.Gender;
import com.mycart.carspiecesseller.entities.enums.Role;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String userName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(unique = true, nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String password;	
	
	@Column(nullable = false)
	private LocalDate createTime;
		
	@Column(nullable = false)
	private Gender gender;
	
	@Column(nullable = false)
	private Role role;
	
	@Transient
	private String token;
	
	
	

}
