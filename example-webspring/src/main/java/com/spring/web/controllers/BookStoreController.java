package com.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ui.beans.Category;

@RestController
@RequestMapping("bookstore")
public class BookStoreController {

	
	@RequestMapping("/category")
	public String createcategory(@Valid Category category ) {
		return "Address";
		
	}
	
}
