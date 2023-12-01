package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.gcu.business.BlogsBusinessService;
import com.gcu.business.BlogsBusinessServiceInterface;
import com.gcu.business.UserService;
import com.gcu.business.UserServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="blogsBusinessService")
	public BlogsBusinessServiceInterface getBlogsBuisiness() {
		return new BlogsBusinessService();
	}
	

	
}
