package com.spring.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.test.jpa.infra.TenantHolder;

public final class RequestInterceptor extends HandlerInterceptorAdapter  {

	
	@Override
	public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String tenant = request.getHeader("tenant-name");
		TenantHolder.setCurrentTenant(tenant);
		return true;
	}

	
	@Override
	public final void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		TenantHolder.releaseTenant();
	}
	
}
