package com.spring.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.web.controllers.AddressController;

@Configuration
@EnableWebMvc
@ComponentScans({@ComponentScan(basePackageClasses = {AddressController.class})})
public class AppWebConfig {

	
	public static void main(String... args) {
		
	}
}
