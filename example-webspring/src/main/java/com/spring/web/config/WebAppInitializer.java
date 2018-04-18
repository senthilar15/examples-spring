package com.spring.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.spring.core.config.AppRootConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		  AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		  rootContext.register(AppRootConfig.class);
		  ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
		  servletContext.addListener(contextLoaderListener);
		  AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		  webContext.register(AppWebConfig.class);
		  DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		  ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		  dispatcher.addMapping("/app");
		
		
	}

}
