package com.example.annotation.movies.recommender;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;

import com.example.annotation.movies.MovieCatalog;
import com.example.annotation.movies.daos.CustomerPreferenceDao;

@Component
public class MovieRecommender {
	
	@Autowired
    private ApplicationContext context; 
	
	@Autowired
    private Environment environment; 
	
	
	@Autowired
    private ResourceLoader resourceLoader; 
	
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher; 
	
	
	@Autowired
    private MessageSource messageSource; 
	
	
	 
    /*
     * You can apply @Autowired to fields as well and even mix it with 
     * constructors:
     */
    @Autowired
    private MovieCatalog actionMovies; 
    
    /*
     * @autowire without qualifier , variable name will be resolved against bean name /bean method name
     *
     */
    
    @Autowired
	private MovieCatalog actionCatelog;
	
	///////////////////////////////////////////////// Collection auto wiring starts ////////////////////////////////////////////////////////////
	
	@Autowired
	private MovieCatalog[] movieCatalogs; //Autowire on array , finds all bean typed Moviecatelog 
	 
    private Set<MovieCatalog> movieCatalogsset;
    
   
	@Autowired
	public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) { //Autowire on set , finds all bean typed Moviecatelog 
	        this.movieCatalogsset = movieCatalogs;
	}
	 
	private Map<String, MovieCatalog> movieCatalogsmap;
	    
	@Autowired
	public void setMovieCatalogs(Map<String, MovieCatalog> movieCatalogs) {
	        this.movieCatalogsmap = movieCatalogs;
	}
	
	
	
	@Autowired
	public void mc(MovieCatalog mc) {
	        this.movieCatalog = mc;
	}
	
	
	
  ///////////////////////////////////////////////// Collection auto wiring ends ////////////////////////////////////////////////////////////
	    
	

	
	private MovieCatalog movieCatalog;

    private CustomerPreferenceDao customerPreferenceDao;
    
 
    
	
   
    
  ///////////////////////////////////////////////// Auto wiring on methods ////////////////////////////////////////////////////////////

    /*
     * @Autowired annotation to methods with arbitrary names and/or 
     * multiple arguments: 
     */
    @Autowired
    public void prepare(@Qualifier("actionMovies")MovieCatalog movieCatalog, CustomerPreferenceDao customerPreferenceDao) {
        this.movieCatalog = movieCatalog;
        this.customerPreferenceDao = customerPreferenceDao;
    }
    
///////////////////////////////////////////////// Auto wiring on methods ////////////////////////////////////////////////////////////
    
    
///////////////////////////////////////////////// Auto wiring on constructor  ////////////////////////////////////////////////////////////
  
//Only one constructor with @Autowired or  @Autowired(required = true) will be allowed , if multiple constructor  @Autowired(required = false) available 
 //then autowire will happen on constructor has more no of arguments satisfying autowiring
    @Autowired(required = false)
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }
    
    
    @Autowired(required = false)
    public MovieRecommender(MovieCatalog movieCatalog, CustomerPreferenceDao customerPreferenceDao) {
    	 this.movieCatalog = movieCatalog;  //Autowire on constructor with higher no of dependency satisfied
         this.customerPreferenceDao = customerPreferenceDao;
    }
///////////////////////////////////////////////// Auto wiring on constructor  ////////////////////////////////////////////////////////////
    
    
    
    ////////////////////////////////////////// @Resource vs @Autowired/////////////////////////////////////////////////////////
    
    
    @Autowired //@Qualifier also can be used
    private List<MovieCatalog> movies;
    
   
    
    /*
     *   @Autowire ,@Resource dependecies resolved in the following manner .
     *   
     *   @Autowire --> byType : looks for a single type resolves against the @Autowire candidate , if more than one type available.
     *                 on Field
     *                 ----------
     *                 a. looks for @primary --> if not available looks for @Qualifier name --> if not available then looks for resolves against the 
     *                    field name 
     *                    
     *                    @Autowired
     *                    private Foo foo; --> looks for @Bean with @Primary : then : looks for @Bean with @Qualifier("foo") : then : looks for method @Bean has name foo()
     *                    
     *                       @Bean
     *                       @Primary //if available
     *                       public Foo foo(){
     *                           return new Foo();
     *                       }
     * 
     *                 on Method and constructor 
     *                 
     *                  a. looks for @primary --> if not available looks for @Qualifier name at parameter level --> if not available then looks for resolves against the 
     *                    method parameter name 
     *                    
     *                    @Autowired
     *                    Public void loadFoo(@Qualifier("foo") Foo foo) or Public void loadFoo(Foo foo)
     *                    
     *                
     *                    
     *                    private Foo foo; --> looks for @Bean with @Primary : then : looks for @Bean with @Qualifier("foo") : then : looks for method @Bean has name foo()
     *                    
     *                       @Bean
     *                       @Primary //if available
     *                       public Foo foo(){
     *                           return new Foo();
     *                       }
     *                       
     *                       If Qualifier is at Class level then resolves against the smaller case of class name.
     *                       
     *                       
     *                       
     *                       @Resource --> byName --> same as @Autowired with some difference. Resolved only at field level and method has single parameter.
     *                       if no name provided @Resource(name="name") --> resolve against the field name for field or method parameter name if resolved against method
     *                       
     * 
     */
    
}
