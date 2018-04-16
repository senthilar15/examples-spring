package com.spring.web.controllers;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfraController {
	
	
	@RequestMapping(path="/locale")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeLocale(Locale locale) {
		System.out.println("Test");
	}

}
