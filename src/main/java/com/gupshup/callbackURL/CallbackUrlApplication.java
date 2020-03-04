package com.gupshup.callbackURL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CallbackUrlApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CallbackUrlApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(CallbackUrlApplication.class, args);
		
		
		
	}

}
