package com.effcode.clean.me.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.effcode.clean.me.model.EmailDetail;
import com.effcode.clean.me.service.EmailService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;

@RestController
@RequestMapping("EmailService")
public class EmailApiController {

	@Autowired
	EmailService emailService;

    @PostMapping("/sendEmail")
    @CircuitBreaker(name="sendMail" , fallbackMethod = "sendMailFallback")
    public ResponseEntity<String> sendMail(@RequestBody @Valid EmailDetail emailDetail) throws Exception {
        boolean state = emailService.sendMail(emailDetail);
        if (state) {
        	ResponseEntity<String> rp = new ResponseEntity<>("Successfully sent the email!", HttpStatus.OK);
            return rp;
        } else {
        	ResponseEntity<String> rp = new ResponseEntity<>("Email sending is failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        	return rp;
        }
    }
    
    public ResponseEntity<String> sendMailFallback(EmailDetail emailDetail, Throwable t) throws Exception {
        	ResponseEntity<String> rp = new ResponseEntity<>("Email service is not available temporarily!", HttpStatus.SERVICE_UNAVAILABLE);
        	return rp;
    }
    
    @GetMapping("/hc")
    @ResponseBody
    public String hc() {
    	 return "Success";
    	 
    }

}
