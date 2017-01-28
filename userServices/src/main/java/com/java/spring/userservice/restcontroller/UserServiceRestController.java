package com.java.spring.userservice.restcontroller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.userservice.model.User;
import com.java.spring.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
public class UserServiceRestController implements Serializable {

	private static final long serialVersionUID = 1L;

	private JmsTemplate jmsTemplate;
	private UserService userService;

	@Autowired
	public UserServiceRestController(JmsTemplate jmsTemplate, UserService userService) {
		this.jmsTemplate = jmsTemplate;
		this.userService = userService;
	}

	@GetMapping
	public ModelAndView newUser() {
		log.info("Init user", UserServiceRestController.class);
		return new ModelAndView("userForm", "user", new User());

	}

	@PostMapping
	public ModelAndView saveUser(User user) {
		this.jmsTemplate.convertAndSend("agenda", this.userService.saveUser(user));
		return new ModelAndView("userForm", "user", new User()); 
	}
}
