package com.ql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import com.ql.service.EmailService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class LombokDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LombokDemoApplication.class, args);
	}
//	@Autowired
//	EmailService emailService;
//	
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerEmail() throws MessagingException {
//		emailService.sendSimpleMail("trinhlong2811@gmail.com", "This is body", "This is Email");
//	}
}



