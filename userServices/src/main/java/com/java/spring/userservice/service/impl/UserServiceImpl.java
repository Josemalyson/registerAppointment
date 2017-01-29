package com.java.spring.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.java.spring.userservice.model.User;
import com.java.spring.userservice.repository.UserRepository;
import com.java.spring.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 617647868799313021L;

	private UserRepository userRepository;
	private JmsTemplate jmsTemplate;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, JmsTemplate jmsTemplate) {
		this.userRepository = userRepository;
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public User saveUser(User user) {
		log.info("Persiste user", UserServiceImpl.class);
		return this.userRepository.save(user);
	}

	@Override
	public void scheduling(User user) {
		this.jmsTemplate.convertAndSend("apointment", "ActiveMQ Ativo Recebendo as Mensagens");

	}

}
