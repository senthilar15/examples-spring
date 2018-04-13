package com.examples.spring;

import com.example.annotation.app.services.TransferService;
import com.example.annotation.movies.SimpleMovieLister;
import com.example.annotation.movies.recommender.MovieRecommender;

public class ExampleAnnotationMain {
	
	static {
		ExampleAppAnnotationConfig.configure();
	}
	
	
	public static void main(String[] a) {
		try {
			
			MovieRecommender mr = ExampleAppAnnotationConfig.lookupBean(MovieRecommender.class);
			//SimpleMovieLister movielister = ExampleAppAnnotationConfig.lookupBean(SimpleMovieLister.class);
			TransferService ts = ExampleAppAnnotationConfig.lookupBean(TransferService.class);
			ts.transfer();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
