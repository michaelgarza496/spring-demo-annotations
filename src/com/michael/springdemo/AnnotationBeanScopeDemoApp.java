package com.michael.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * to provide the scope use @Scope under the @Component
 * 
 * @PostConstruct will execute after constructor and injection of dependencies
 * @PreDestroy will execute before bean is destroyed
 * 
 * A prototype bean will not have it's @PreDestroy method called. This bean is handed
 * to the client and the spring container is pretty much done with it.
 */

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);
		
		// close context
		context.close();
	}
}
