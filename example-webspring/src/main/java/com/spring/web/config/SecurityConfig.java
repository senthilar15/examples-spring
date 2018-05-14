package com.spring.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.daos.store.UserDetailDao;
import com.spring.services.store.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserDetailDao userRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/app/**").hasRole("admin").
		anyRequest().authenticated().
		and().
		formLogin().defaultSuccessUrl("/app/bookstore/category/1");
	}
	
	
	
	/*public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		  auth.inMemoryAuthentication().withUser("admin").password("admin");
		
	}
	*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailServiceImpl(this.userRepository);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	/*@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		
		@Autowired
		private UserDetailDao userRepository;
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			
			UserDetails  user = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("admin").build();
			
			auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(user);

		}
		
		@Bean
		public UserDetailsService userDetailsService() {
			return new UserDetailServiceImpl(this.userRepository);
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
	} */
	
	
	public static void main(String[] a) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
		
	}
	
}
