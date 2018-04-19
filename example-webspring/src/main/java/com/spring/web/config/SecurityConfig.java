package com.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/app/**").hasRole("admin").
		/*.authenticated().*/
		and().
		formLogin().defaultSuccessUrl("/app/bookstore/category");
	}
	
	
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		  auth.inMemoryAuthentication().withUser("admin").password("admin");
		
	}
	
	
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			
			UserDetails  user = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("admin").build();
			
			auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(user);

		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
	} 
	
}
