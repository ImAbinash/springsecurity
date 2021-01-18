package com.khub.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests((requests) -> requests.antMatchers("/myAccount").authenticated().antMatchers("/myCards")
//				.authenticated().antMatchers("/myLoans").authenticated().antMatchers("/myBalance").authenticated()
//				.antMatchers("/notices").permitAll().antMatchers("/contacts").permitAll());
//		http.formLogin();
//		http.httpBasic();
//		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
//	}
	

	/***
	 * Deny all requests
	 * Usage: suppose wants to stop consuming the api's at mid night then we need to implement it.
	 */
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests((requests) -> requests.anyRequest().denyAll());
//		http.formLogin();
//		http.httpBasic();
//	}
	

	/***
	 * Allow all requests
	 * Usage: Sometimes we need to permit all request to consume.
	 */
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests((requests) -> requests.anyRequest().permitAll());
//		http.formLogin();
//		http.httpBasic();
//	}
	
	/**
	 *  We used inMemoryAuthentication here to describe user and password with role.
	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("test").password("test").authorities("admin").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
	
	
	/**
	 * Here we used InMemoryUserDetailsManager to manage user details
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		UserDetails user1 = User.withUsername("admin").password("password").authorities("admin").build();
		UserDetails user2 = User.withUsername("user").password("password").authorities("admin").build();
		userDetailsService.createUser(user1);
		userDetailsService.createUser(user2);
		auth.userDetailsService(userDetailsService);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
