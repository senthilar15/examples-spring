package com.example.annotation.movies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*@Qualifier("comedy")*/
/*@Component*/
public class ComedyMoviesCatelog extends MovieCatalog{

	public ComedyMoviesCatelog() {
		super();
	}
	
	public ComedyMoviesCatelog(String genre) {
		super(genre);
	}

}
