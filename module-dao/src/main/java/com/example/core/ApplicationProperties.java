package com.example.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;


public class ApplicationProperties {
	
	private static Properties properties = new Properties();
	
	private static List<String> vendors;

    static {
    	
    	try {
			initialize();
		} catch (IOException e) {
             throw new RuntimeException(e);
		}
    	
    }
	
	private static void initialize() throws IOException {
	
		InputStream stream = ResourceUtil.loadFromClasspath("application.properties");
		properties.load(stream);
		vendors = Collections.unmodifiableList(Arrays.asList(properties.getProperty("tenants").split(",")));
	}
	
	
	public static List<String> getVendors(){
		return vendors;
	}
	
	public static String getDBVendor(String tenant) {
		return properties.getProperty(tenant+".dbvendor");
	}
	
	public static String getSchema(String tenant) {
		return properties.getProperty(tenant+".schema");
	}
	
	public static String getJdbcUrl(String tenant) {
		return properties.getProperty(tenant+".jdbcurl");
	}
	
	
	public static String getUserName(String tenant) {
		return properties.getProperty(tenant+".username");
	}
	
	public static String getPassword(String tenant) {
		return properties.getProperty(tenant+".password");
	}
	
	public static String getTenantName(String tenant) {
		return properties.getProperty(tenant+".tenant");
	}
	
}
