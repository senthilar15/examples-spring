package com.test.jpa.infra;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.stereotype.Component;

@Component
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 1L;
	
	@Autowired
    private DataSourceLookup dataSourceLookup;
	
	
	@Override
	protected DataSource selectAnyDataSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
	        return dataSourceLookup.getDataSource(tenantIdentifier);
	}

}
