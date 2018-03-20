package com.example.annotation.movies;

import org.springframework.stereotype.Component;

import com.example.annotation.movies.qualifiers.MovieQualifier;

/*@MovieQualifier(format=com.example.annotation.movies.qualifiers.Format.VHS, genre="Action")*/
/*@Component*/
public class ActionMovieCatelog extends MovieCatalog{

	public ActionMovieCatelog() {
		super();
	}
	public ActionMovieCatelog(String genre) {
		super(genre);
	}

}
