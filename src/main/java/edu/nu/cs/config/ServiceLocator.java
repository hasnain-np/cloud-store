package edu.nu.cs.config;

import edu.nu.cs.service.IService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator implements ApplicationContextAware {

	private static ApplicationContext context;

	public static IService getService (String name){
		return (IService)getContext().getBean(name);
	}
	
	private static ApplicationContext getContext(){
		return context;
	}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ServiceLocator.context = applicationContext;
    }
}
