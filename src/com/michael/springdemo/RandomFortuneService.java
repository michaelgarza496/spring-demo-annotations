package com.michael.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String data[] = new String[3];
	
	@Value("${fortune1}")
	private String f1;
	
	@Value("${fortune2}")
	private String f2;
	
	@Value("${fortune3}")
	private String f3;
	
	@PostConstruct
	public void setFortuneValues() {
		// create an array of strings
		data[0] = f1;
		data[1] = f2;
		data[2] = f3;
	}

	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick random string from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune;
	}

}
