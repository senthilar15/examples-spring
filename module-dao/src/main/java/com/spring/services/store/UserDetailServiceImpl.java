package com.spring.services.store;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.daos.store.UserDetailDao;
import com.spring.daos.store.UserDetailsImpl;

public class UserDetailServiceImpl implements UserDetailsService {

	

	private UserDetailDao userdetailsDao;
	
	public UserDetailServiceImpl(UserDetailDao userdetailsDao) {
		this.userdetailsDao = userdetailsDao;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		UserDetailsImpl ud = new UserDetailsImpl(userdetailsDao.loadUserByUsername(userId));
		
		return ud;
	}

}
