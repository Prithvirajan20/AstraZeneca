package com.effcode.clean.me.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests()
		.requestMatchers("/sendEmail").authenticated()
		.requestMatchers("/hc").permitAll()
		.and().httpBasic()
		.and().csrf(AbstractHttpConfigurer::disable);
		
		return http.build();
		
		
	}
	
	
	
}
