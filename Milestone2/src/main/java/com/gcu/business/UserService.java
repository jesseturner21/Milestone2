package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.entity.BlogEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import com.gcu.model.BlogModel;
import com.gcu.model.SignUpModel;

public class UserService implements UserServiceInterface{

	
	@Autowired 
	UserRepository repo;
	
	@Override
	public void test() {
		System.out.println("Hello");	
	}

	@Override
	public List<SignUpModel> getUsers() {
		// Create some Orders
		List<SignUpModel> orders = new ArrayList<SignUpModel>();
		
		
		return orders;
	}

	
	@Override
	public UserEntity createUser(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setUsername(username);
        user.setPassword(password);
        
        return repo.save(user);
        
	}
	
	public UserEntity getUserByUsername(String username) {
		return repo.findUserByUsername(username);
	}
	
	
}
