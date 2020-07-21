package io.gupshup.callbackService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CallbackServiceApplication extends SpringBootServletInitializer {
	
	private static final Logger log=LoggerFactory.getLogger(CallbackServiceApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(CallbackServiceApplication.class, args);

	}

}


