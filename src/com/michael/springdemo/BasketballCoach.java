package com.michael.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice dribbling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return "Your awesome!";
	}

}
