package com.michael.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 3 types of dependency injections for autowired annotations
 * 		constructor
 * 		setter or really and method
 * 		field
 */


public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
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
