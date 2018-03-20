package com.example.annotation.movies;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*@Component*/
//@Scope(value="prototype")
public class MovieCatalog {
	
	public MovieCatalog(){
		
	}
	
	private String genre;
	
	public MovieCatalog(String genre){
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Movie catelog is "+genre;
	}

}
