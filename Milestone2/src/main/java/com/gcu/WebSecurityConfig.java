package com.gcu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserService;
@Configuration
public class WebSecurityConfig {
	
	@Autowired
	UserService service;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http 
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/" , "/signUp", "doSignUp","/images/**", "/service/**").permitAll()
				.anyRequest().authenticated ())
	.formLogin(form -> form
			.loginPage("/login" )
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.defaultSuccessUrl("/", true)) 
	.logout (lo -> lo
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.logoutSuccessUrl("/"));
	return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth
	.userDetailsService(service)
	.passwordEncoder(new BCryptPasswordEncoder());

}
}