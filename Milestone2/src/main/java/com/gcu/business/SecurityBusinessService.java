package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	
	public boolean authenticate(String username, String password) {
		String realPassword = "password";
		if(password.equals(realPassword))
		System.out.println("Hello from the SecurityBusinessService");
		return true;
		
	}
}
