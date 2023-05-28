package com.ql.service;

import com.ql.entity.EmailDetails;

import jakarta.mail.MessagingException;

public interface EmailService {
	void sendSimpleMail(String toEmail, String body,String subJect) throws MessagingException;
}
