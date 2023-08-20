package com.effcode.clean.me.config;

import org.springframework.context.annotation.Bean;

import com.effcode.clean.me.support.SmtpHandler;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
    public SmtpHandler smtpHandler() {
		System.out.println("Bean is getting created..");
        return new SmtpHandler();
    }

}
