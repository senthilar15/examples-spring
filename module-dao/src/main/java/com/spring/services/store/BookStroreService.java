package com.spring.services.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.daos.store.BookStoreDao;
import com.test.ui.beans.Category;

@Service
public class BookStroreService {
	
	
	@Autowired
	private BookStoreDao bookStoreDao;
	
	public Category findCategory( int category ) {
		return bookStoreDao.findCategory(category);	
	}
	
	
	public Category createCategory(Category category) {
		return bookStoreDao.createCategory(category);
	}
	

}
