package com.spring.web.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.spring.web.interceptors.RequestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.web")
public class AppWebConfig implements WebMvcConfigurer {

	
		public static void main(String... args) {
			
		}
		
	
	    @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("classpath:/validationmessages");
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }
	 
	 
	    @Bean
	    public LocaleResolver localeResolver(){
			CookieLocaleResolver resolver = new CookieLocaleResolver();
			resolver.setDefaultLocale(new Locale("en"));
			resolver.setCookieName("locale_cookie");
			resolver.setCookieMaxAge(4800);
			return resolver;
	    }
	    
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
			LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
			interceptor.setParamName("lang");
			registry.addInterceptor(interceptor);
			registry.addInterceptor(new RequestInterceptor());
			
	    }
}
