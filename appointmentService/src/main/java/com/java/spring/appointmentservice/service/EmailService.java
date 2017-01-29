package com.java.spring.appointmentservice.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.java.spring.appointmentservice.model.User;

@Service
public class EmailService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4684469510250180466L;

	private JavaMailSender javaMailSender;

	@Value("${spring.mail.destination}")
	private String destination;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(User user) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(destination);
		simpleMessage.setText("Scheduling of user confirming" + LocalDateTime.now());
		javaMailSender.send(simpleMessage);
	}

}
