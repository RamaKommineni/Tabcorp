package com.bank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.bank.account.*" })
@EnableJpaRepositories
@EnableAutoConfiguration(exclude= {SecurityAutoConfiguration.class})
public class BankAccountApplication {  

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}
}
