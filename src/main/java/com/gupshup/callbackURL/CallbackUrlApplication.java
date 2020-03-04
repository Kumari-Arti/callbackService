package com.gupshup.callbackURL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CallbackUrlApplication {
	
	private static final Logger log=LoggerFactory.getLogger(CallbackUrlApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(CallbackUrlApplication.class, args);
		

	}
}


