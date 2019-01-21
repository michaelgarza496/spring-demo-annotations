package com.michael.springdemo;

import org.springframework.stereotype.Component;
// if no name is given for the bean id, then the default will be used
// @Component will have the default bean of @Component("tennisCoach")
// camel case is required

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
