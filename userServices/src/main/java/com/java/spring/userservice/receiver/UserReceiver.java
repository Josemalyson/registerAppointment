package com.java.spring.userservice.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.java.spring.userservice.model.User;

@Component
public class UserReceiver {

	@JmsListener(destination = "userReceiver", containerFactory = "userServiceFactory")
	public void receiveMessage(User user) {
		System.out.println(user.toString());
	}

}
