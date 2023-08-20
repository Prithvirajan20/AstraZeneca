package com.effcode.clean.me.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmailDetail {
	
	@Email(message = "Invalid Email Address")
	private String mailAddress;
	
	@NotBlank(message = "Invalid Subject: Empty subject")
    @NotNull(message = "Invalid Subject: Subject is NULL")
	private String subject;
	
	private String content;
	
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
