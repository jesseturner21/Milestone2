package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.business.BlogsBusinessService;
import com.gcu.business.BlogsBusinessServiceInterface;
import com.gcu.business.UserService;
import com.gcu.business.UserServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="blogsBusinessService", initMethod="init", destroyMethod="destroy")
	public BlogsBusinessServiceInterface getBlogsBuisiness() {
		return new BlogsBusinessService();
	}
	
	@Bean(name="userBusinessService", initMethod="init", destroyMethod="destroy")
	public UserServiceInterface getUserBuisiness() {
		return new UserService();
	}
	
}
