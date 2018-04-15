package com.spring.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {
	
	@RequestMapping("/addres")
	public String address() {
		return "Address";
	}

}
