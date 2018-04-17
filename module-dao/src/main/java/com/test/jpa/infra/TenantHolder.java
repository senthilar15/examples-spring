package com.test.jpa.infra;

import org.springframework.util.StringUtils;

public class TenantHolder {
	
	private static ThreadLocal<String> tenantName = new ThreadLocal<String>();
	
	public static String currentTenant() {
		return tenantName.get();
	}
	
	public static void setCurrentTenant(String tenant) {
		if(StringUtils.isEmpty(tenant)) {
			tenant = "tenant1";
		}
		tenantName.set(tenant);
	}
	
	public static void releaseTenant() {
		tenantName.set(null);
	}
	

}
