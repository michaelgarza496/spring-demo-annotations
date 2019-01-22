package com.michael.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// if no name is given for the bean id, then the default will be used
// @Component will have the default bean of @Component("tennisCoach")
// camel case is required



@Component
public class TennisCoach implements Coach {
	
	// field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define default contructor
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside of doMyStartupStuff() method");
	}
	
	// define my destroy method
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("TennisCoach: inside of doCleanupStuff() method");
	}
	
	/*
	// constructor injection - inject the happyfortuneservice
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	/*
	// define setter method for setter injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach: inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	// any method can be autowired
	@Autowired
	public void myMethod(FortuneService fortuneService) {
		System.out.println("TennisCoach: inside myMethod() method");
		this.fortuneService = fortuneService;
	}
	*/
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
