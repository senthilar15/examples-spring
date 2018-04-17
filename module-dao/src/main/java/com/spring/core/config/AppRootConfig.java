package com.spring.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.spring")
public class AppRootConfig {
	
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
		lcemfb.setDataSource(dataSource());
		lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
		lcemfb.setPackagesToScan("com.test.jpa");
		lcemfb.setJpaProperties(jpaProperties());
		return lcemfb;
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		
        HikariDataSource dataSource = new HikariDataSource();
        
        dataSource.setPoolName("hikari-pool-");
		String jdbcUrl = env.getProperty("db.jdbcurl");
		dataSource.setMinimumIdle(2);
		dataSource.setMaximumPoolSize(4);
		dataSource.setIdleTimeout(1000*60*5);
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean
	public PlatformTransactionManager txManager(){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return jpaTransactionManager;
	}
	 private Properties jpaProperties() {
         Properties properties = new Properties();
         properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
         properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
         properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
         return properties;        
   }

}
