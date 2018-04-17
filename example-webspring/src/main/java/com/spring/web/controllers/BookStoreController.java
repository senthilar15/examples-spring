package com.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.services.store.BookStroreService;
import com.test.ui.beans.Category;

@RestController
@RequestMapping("bookstore")
public class BookStoreController {

	
	@Autowired
	private BookStroreService bkService;
	
	
	@RequestMapping(value ="/category", method=RequestMethod.POST,  headers = {"Content-Type=application/JSON"})
	@ResponseStatus(HttpStatus.CREATED)
	public Category createcategory(@Valid @RequestBody Category category ) {
		return bkService.createCategory(category);	
	}
	
}
