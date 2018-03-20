package com.example.annotation.movies;

import org.springframework.stereotype.Component;

import com.example.annotation.movies.qualifiers.Genre;

/*@Genre(value="offline")*/
/*@Component*/
public class OfflineMovieCatelog extends MovieCatalog{

	public OfflineMovieCatelog() {
		super();
	}
	public OfflineMovieCatelog(String genre) {
		super(genre);
	}

}
