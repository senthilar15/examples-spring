package com.example.annotation.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.example.annotation.movies.finder.MovieFinder;

@Component
public class SimpleMovieLister {
	
	@Autowired
	private MovieFinder movieFinder;
	
	private MovieFinder movieFinder1;
	
	
	/*
	 * 
	 * As of Spring Framework 4.3, an @Autowired annotation on such a 
	 * constructor is no longer necessary if the target bean only defines 
	 * one constructor to begin with. However, if several constructors are
	 *  available, at least one must be annotated to teach the container 
	 *  which one to use.
	 */
	
	@Autowired
    public SimpleMovieLister(MovieFinder movieFinder) {
    	this.movieFinder1 = movieFinder;
    }
	
	
	@Required //must be satisfied , otherwise throws error (@Autowired || @Inject)
    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

}
