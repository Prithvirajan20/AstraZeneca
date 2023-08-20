package com.effcode.clean.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.effcode.clean.me")
public class CleanMeRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(CleanMeRestApplication.class, args);
	}
}
