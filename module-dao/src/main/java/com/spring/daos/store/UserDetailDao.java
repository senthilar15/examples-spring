package com.spring.daos.store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.jpa.AppUser;

@Repository
public class UserDetailDao {
	
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public AppUser loadUserByUsername(String userid) {
		AppUser user = em.find(AppUser.class, userid);
		if(user == null) {
			throw new UsernameNotFoundException("No user present");
		}
		return user;
	}

}
