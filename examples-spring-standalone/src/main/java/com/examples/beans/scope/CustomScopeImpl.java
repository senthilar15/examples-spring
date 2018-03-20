package com.examples.beans.scope;

import org.springframework.beans.factory.ObjectFactory;

/*
 *    
 * <aop:scoped-proxy/> --  must be defined to inject a short lived collaborator bean 
 * into long lived bean
 * 
 * E.g --> A request scoped/session scoped bean must be injected into singleteon through proxy 
 *  Why ?  
 *  Singleton will only be instantiated by container only one time and dependencies
 *  also injected at the time the singleton object created ,to avoid this proxy 
 *  bean needs to be injected so that proxy will take care of delegating to the actual 
 *  scoped bean . CGlib is being used to create pxoxy by default
 *  
 *  proxy is nothing but a class contains all the public methods of a bean scoped to
 *  request or session
 *  
 *  
 *  usermanager <---- userpreference (session scope)
 * 
 * 
 */


public class CustomScopeImpl implements CustomScope{

	@Override
	public Object get(String arg0, ObjectFactory<?> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerDestructionCallback(String arg0, Runnable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object resolveContextualObject(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
