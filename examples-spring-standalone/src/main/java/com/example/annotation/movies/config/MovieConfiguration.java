package com.example.annotation.movies.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.annotation.movies.ActionMovieCatelog;
import com.example.annotation.movies.ComedyMoviesCatelog;
import com.example.annotation.movies.MovieCatalog;
import com.example.annotation.movies.OfflineMovieCatelog;
import com.example.annotation.movies.qualifiers.Genre;
import com.example.annotation.movies.qualifiers.MovieQualifier;

/**
 *  Registering a bean definition
 *  
   1. @Bean method in a @Configuration class or <bean> in XML configuration
   2. @Component (and its meta-annotations, eg. @Repository) through @ComponentScan or <context:component-scan ... /> in XML
   3. Manually through GenericApplicationContext#registerBeanDefinition
   4. Manually through BeanDefinitionRegistryPostProcessor
 * 
 *
 */

@Configuration
@ComponentScan(basePackages = "com.example.annotation.movies")
public class MovieConfiguration {
	
	
	//Qualifies the MovieCatelog objects as bean throug @Bean , calls all method with @Bean while startup
	
	@Bean
   /* @Primary*/
    @Qualifier("action")
    public MovieCatalog actionMovies() {  
		 return new ActionMovieCatelog("action");
	}
	
	
	@Bean
    public MovieCatalog actionCatelog() {  
		 return new ActionMovieCatelog("action movies catelog");
	}

    @Bean
    @MovieQualifier(format=com.example.annotation.movies.qualifiers.Format.VHS, genre="comedy")
    public MovieCatalog comedyMovies() {
    	 return new ComedyMoviesCatelog("comedy");
    }
    
    @Bean
    @MovieQualifier(format=com.example.annotation.movies.qualifiers.Format.DVD, genre="comedy")
    public MovieCatalog comedyMoviesonDvd() {
    	 return new ComedyMoviesCatelog("comedy on dvd");
    }
    
    @Bean
    @Genre("offline")
    public MovieCatalog offlineMovies() {
    	 return new OfflineMovieCatelog("offline");
    }
    
    
    @Bean
    public List<MovieCatalog> movieList() {
    	 return Arrays.asList(new OfflineMovieCatelog("offline"));
    }
    
    
    @Bean
    public MovieCatalog mc() {
    	 return new OfflineMovieCatelog("offline");
    }

}