package com.test.jpa.infra;

import java.util.List;

import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup;
import org.springframework.stereotype.Component;

import com.example.core.ApplicationProperties;
import com.zaxxer.hikari.HikariDataSource;


@Component(value = "dataSourceLookup")
public class MultiTenantDataSourceLookup extends MapDataSourceLookup{
	
	MultiTenantDataSourceLookup(){
		init();
	}

	private void init() {
		
		List<String> tenants = ApplicationProperties.getVendors();
		tenants.stream().forEach(this::createDataSource);
			
		
	}
	
	private void createDataSource(String tenant) {
		
		 HikariDataSource dataSource = new HikariDataSource();
		 dataSource.setPoolName("hikari-pool-"+tenant);
		 String jdbcUrl = ApplicationProperties.getJdbcUrl(tenant);
		 dataSource.setMinimumIdle(2);
		 dataSource.setMaximumPoolSize(4);
		 dataSource.setIdleTimeout(1000*60*5);
		 dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 dataSource.setJdbcUrl(jdbcUrl);
		 dataSource.setUsername(ApplicationProperties.getUserName(tenant));
		 dataSource.setPassword(ApplicationProperties.getPassword(tenant));
		 addDataSource(tenant, dataSource);    
	       
		
		
	}
	
	

}
