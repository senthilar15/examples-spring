package com.example.annotation.movies;

import org.springframework.stereotype.Component;

import com.example.annotation.movies.qualifiers.Genre;

/*@Genre(value="offline")*/
/*@Component*/
public class OfflineMovieCatelog extends MovieCatalog{

	private String genre;


	public OfflineMovieCatelog() {
		super();
		this.genre ="Empty";
	}
	public OfflineMovieCatelog(String genre) {
		super(genre);
		this.genre = genre;
	}
	
	
	public String getGenre() {
		return genre;
	}

}
