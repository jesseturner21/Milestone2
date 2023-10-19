package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.BlogModel;
import com.gcu.model.SignUpModel;

public class UserService implements UserServiceInterface{

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
	
	
}
