package com.example.annotation.movies.finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.annotation.movies.MovieCatalog;
import com.example.annotation.movies.qualifiers.Genre;
import com.example.annotation.movies.qualifiers.MovieQualifier;

@Component
public class MovieFinder {
	
	public MovieFinder() {
		System.out.println("Coming here");
	}
	
	@Qualifier("action")
	@Autowired
	private MovieCatalog actionMovie;
	
	@MovieQualifier(format=com.example.annotation.movies.qualifiers.Format.DVD, genre="comedy")
	@Autowired
	private MovieCatalog comedyMovieOnDvd;
	
	@MovieQualifier(format=com.example.annotation.movies.qualifiers.Format.VHS, genre="comedy")
	@Autowired
	private MovieCatalog comedyMovie;
	
	@Genre("offline")
	@Autowired
	private MovieCatalog offline;

}
