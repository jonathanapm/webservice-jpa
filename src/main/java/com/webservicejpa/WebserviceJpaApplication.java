package com.webservicejpa;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebserviceJpaApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(WebserviceJpaApplication.class)
				.run(args);
	}

}

