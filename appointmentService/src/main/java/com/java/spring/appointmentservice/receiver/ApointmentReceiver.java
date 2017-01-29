package com.java.spring.appointmentservice.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.java.spring.appointmentservice.model.User;
import com.java.spring.appointmentservice.service.EmailService;

@Component
public class ApointmentReceiver {

	private EmailService emailService;
	
	@Autowired
	public ApointmentReceiver(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@JmsListener(destination = "apointment", containerFactory = "appointmentServiceFactory")
	public void receiveMessage(String message) {
		System.out.println(message);
		emailService.sendEmail(new User());
	}

}
