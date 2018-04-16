package com.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.ui.beans.Category;

@RestController
@RequestMapping("bookstore")
public class BookStoreController {

	
	@RequestMapping(value ="/category", method=RequestMethod.POST,  headers = {"Content-Type=application/JSON"})
	@ResponseStatus(HttpStatus.CREATED)
	public Category createcategory(@Valid @RequestBody Category category ) {
		return category;	
	}
	
}
