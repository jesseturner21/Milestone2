package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.data.entity.UserEntity;
import com.gcu.model.BlogModel;
import com.gcu.model.SignUpModel;

public class TestUserService implements UserServiceInterface{

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
	public UserEntity createUser(String firstName, String lastName, String email, String phoneNumber, String username,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
