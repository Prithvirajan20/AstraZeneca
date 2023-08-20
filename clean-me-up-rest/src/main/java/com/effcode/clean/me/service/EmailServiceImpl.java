package com.effcode.clean.me.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.effcode.clean.me.model.EmailDetail;
import com.effcode.clean.me.support.SmtpEmail;
import com.effcode.clean.me.support.SmtpHandler;

@Service
public class EmailServiceImpl implements EmailService{
	
	
	@Autowired
    SmtpHandler smtpHandler;
	
	@Value("${emailservice.username}")
	private String userName;
	
	@Value("${emailservice.password}")
	private String password;
	
	Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Override
	public boolean sendMail(EmailDetail emailDetail) throws Exception {
		
		try {
			
			log.debug("Adr: " + emailDetail.getMailAddress());
	        log.debug("Subject: " + emailDetail.getSubject());
	        log.debug("Content: " + emailDetail.getContent());
	        if(emailDetail.getSubject() == null) {
	            log.error("Subject is null");
	            return false;
	        }
	        if(emailDetail.getContent().length() > 65000) {
	            log.error("Content to BIG: " + emailDetail.getContent().length());
	            return false;
	        }
	        SmtpEmail smtpEmail = new SmtpEmail();
	        smtpEmail.adrs = new String[] {emailDetail.getMailAddress()};
	        smtpEmail.content = emailDetail.getContent();
	        smtpEmail.subject = emailDetail.getSubject();
	        smtpEmail.password =  password;
	        smtpEmail.username = userName;
	        smtpHandler.post(smtpEmail);
	        
	        System.out.println(smtpEmail);
	        
	        log.info("Send email. Adr: " + emailDetail.getMailAddress() + ", Subject: " + emailDetail.getSubject());
	        return true;
			
		}catch(Exception e) {
			log.error("Exception at sendMail service");
			throw new Exception(e.getMessage());
		}
	}

}