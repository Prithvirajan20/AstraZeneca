package com.effcode.clean.me.service;

import com.effcode.clean.me.model.EmailDetail;

public interface EmailService {
	
	public boolean sendMail(EmailDetail emailDetail) throws Exception;

}
