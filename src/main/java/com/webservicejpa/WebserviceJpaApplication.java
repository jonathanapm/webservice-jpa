package com.webservicejpa;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class WebserviceJpaApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(WebserviceJpaApplication.class)
				.run(args);
	}
}


