package com.examples.beans.scope;

/*
 * Custom scope which can be used as an alternate to 
 * 
 * singleton -- @Singleton
 * prototype
 * request  -- @RequestScope
 * session  -- @SessionScope
 * application -- @ApplicationScope
 * 
 * 
 */


public interface CustomScope extends  org.springframework.beans.factory.config.Scope{

}
