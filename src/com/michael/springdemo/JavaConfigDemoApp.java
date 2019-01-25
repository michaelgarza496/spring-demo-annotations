package com.michael.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 3 types of dependency injections for autowired annotations
 * 		constructor
 * 		setter or really and method
 * 		field
 * 
 * @Qualifier(classname with lowercase first letter)
 * This will help resolve the problem with multiple implementations
 * when trying to autowiring for injection.
 * When doing constructor, the @Qualifier has to be inside the parameter.
 * ex: myConstructor(@Qualifier("theOneYouWant")MyObject myObject) {...}
 * 
 * 
 * for properties you still have to define the properties file and use @Value("${foo.name}")
 * make sure to use @PostConstruct so the values of the properties values can be used since
 * it's extracted at the end.
 * 
 * When Spring creates the beans it follows this general process

	1. Construct an instance of class
	2. Inject dependencies
	3. Set properties etc (@Value)
 */


/*
 * You can configure the application context without an xml
 * Create a java class with the annotations @Configuration, @ComponentScan("com.michael.springdemo")
 * Instead of the ClassPathXMLConfiguration use AnnotationConfigApplicationContext(SportConfig.class)
 */

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
