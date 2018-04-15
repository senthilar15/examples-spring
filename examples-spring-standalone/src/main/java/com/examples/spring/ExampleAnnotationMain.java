package com.examples.spring;

import com.example.annotation.app.services.AccountService;
import com.example.annotation.app.services.TransferService;
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
			//ts.transfer();
			//ts.within();
			//ts.afterReturning();
			// ts.afterThrowing();
			// ts.after();
			AccountService as = ExampleAppAnnotationConfig.lookupBean(AccountService.class);
			//as.transfer();
			
			as.annotatedTransfer();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
