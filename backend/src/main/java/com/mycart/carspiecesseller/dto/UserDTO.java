package com.mycart.carspiecesseller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.Gender;
import com.mycart.carspiecesseller.entities.enums.Role;

public class UserDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String phoneNumber;
	private LocalDate createTime;
	private Gender gender;
	private Role role;
	
	private List<OrderDTO> orders = new ArrayList<>();
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String firstName, String lastName, String username, String email, String phoneNumber,
			LocalDate createTime, Gender gender, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.createTime = createTime;
		this.gender = gender;
		this.role = role;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		gender = entity.getGender();
		email = entity.getEmail();
		phoneNumber = entity.getPhoneNumber();
		username = entity.getUsername();
		createTime = entity.getCreateTime();		
		role = entity.getRole();
		orders = entity.getOrders().stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public LocalDate getCreateTime() {
		return createTime;
	}

	
	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	
	public Gender getGender() {
		return gender;
	}

	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	
	public void setRole(Role role) {
		this.role = role;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}
	
	

}
