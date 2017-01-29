package com.java.spring.userservice.restcontroller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.userservice.model.User;
import com.java.spring.userservice.service.UserService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
public class UserServiceRestController implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserService userService;
	
	@Getter
	@Setter
	private boolean display;

	@Autowired
	public UserServiceRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ModelAndView newUser() {
		log.info("Init user", UserServiceRestController.class);
		this.display = false;
		return new ModelAndView("userForm", "user", new User());

	}

	@GetMapping("/scheduling")
	public ModelAndView schedulingUser(User user) {
		this.userService.scheduling(user);
		this.display = true;
		return new ModelAndView("confirmuserscheduling", "display", new User());

	}

	@PostMapping
	public ModelAndView saveUser(User user) {
		User userBd = this.userService.saveUser(user);
		ModelAndView model = new ModelAndView("confirmuserscheduling");
		model.addObject("user", userBd);
		return model;
	}
}
