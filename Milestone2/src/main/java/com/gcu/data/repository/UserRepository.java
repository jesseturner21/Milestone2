package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.data.entity.UserEntity;



public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	@Override
	@Query(value = "SELECT * FROM USERS ")
	public List<UserEntity> findAll();
	
	
	@Query("SELECT * FROM USERS WHERE USERS.username = :username")
	public UserEntity findUserByUsername(@Param("username") String username);
}
