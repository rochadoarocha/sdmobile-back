package com.sdmobile.sdmobileback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdmobileBackApplication {

	public static void main(String[] args) {
		
		
		String PORT = System.getenv("PORT");
		
		SpringApplication.run(SdmobileBackApplication.class, args);
	}

}
