package com.effcode.clean.me.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.mvcMatchers("/").authenticated()
		.mvcMatchers("/sendEmail").authenticated()
		.and().httpBasic().and().csrf().disable().headers().contentSecurityPolicy("frame-ancestors 'none'; default-src 'self'; script-src 'strict-dynamic'");
		
	}

}
