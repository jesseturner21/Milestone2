package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.BlogEntity;

public interface BlogRepository extends CrudRepository<BlogEntity, Long> {
	

}
