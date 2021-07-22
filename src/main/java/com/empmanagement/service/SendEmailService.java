package com.empmanagement.service;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements ISendEmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendMail(String subject, String message, String email) {
		
		SimpleMailMessage mesg = new SimpleMailMessage();
        mesg.setTo(email);
                
        mesg.setSubject(subject);
        mesg.setText(message);

        javaMailSender.send(mesg);	
        
        System.out.println("MAil sent successfully");	
		
	}

}
