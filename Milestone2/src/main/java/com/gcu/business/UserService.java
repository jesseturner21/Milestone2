package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.BlogEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import com.gcu.model.BlogModel;
import com.gcu.model.SignUpModel;
@Service
public class UserService implements UserDetailsService{

	
	@Autowired 
	UserRepository repo;
	
	
	public void test() {
		System.out.println("Hello");	
	}

	public List<SignUpModel> getUsers() {
		// Create some Orders
		List<SignUpModel> orders = new ArrayList<SignUpModel>();
		
		
		return orders;
	}

	
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
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = repo.findUserByUsername(username);
		if(user !=null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else {
			throw new UsernameNotFoundException("username not found: " + username);
		}
	}
	
}
