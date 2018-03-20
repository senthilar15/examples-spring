package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DemoBeanOverridedLifeCycle  implements InitializingBean, DisposableBean  {

	@Override
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("DemoBeanOverridedLifeCycle Destroyed");
		
	}

	@Override
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("DemoBeanOverridedLifeCycle Initialized");
		
	}

}
