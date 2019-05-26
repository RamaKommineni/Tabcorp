package com.tabcorp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.tabcorp.application.*" })
@EnableJpaRepositories("com.tabcorp.application.dao")
@EntityScan("com.tabcorp.application")
@EnableAutoConfiguration(exclude= {SecurityAutoConfiguration.class})
public class TabcorpApplication {  

	public static void main(String[] args) {
		SpringApplication.run(TabcorpApplication.class, args);
	}
}
