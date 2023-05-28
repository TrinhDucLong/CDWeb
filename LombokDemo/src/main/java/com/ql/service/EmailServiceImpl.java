package com.ql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ql.entity.EmailDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendSimpleMail(String toEmail, String body, String subJect) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper =new MimeMessageHelper(message,true);
		helper.setFrom("khoit1666@gmail.com");
		helper.setTo(toEmail);
		helper.setText(body);
		helper.setSubject(subJect);
		
		javaMailSender.send(message);
		System.out.println("mail");
		
		
		 
	
	}

	


}
