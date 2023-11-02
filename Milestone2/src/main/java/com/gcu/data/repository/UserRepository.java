package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserEntity;



public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	@Override
	@Query(value = "SELECT * FROM USERS ")
	public List<UserEntity> findAll();
}
