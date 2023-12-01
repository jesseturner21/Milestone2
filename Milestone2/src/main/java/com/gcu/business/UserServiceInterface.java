package com.gcu.business;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gcu.data.entity.UserEntity;
import com.gcu.model.SignUpModel;

public interface UserServiceInterface {
	public void test();
	public List<SignUpModel> getUsers();
	public UserEntity createUser(String firstName, String lastName, String email, String phoneNumber, String username, String password);
	public UserEntity getUserByUsername(String username);
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
