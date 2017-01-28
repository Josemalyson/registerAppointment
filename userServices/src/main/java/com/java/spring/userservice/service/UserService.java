package com.java.spring.userservice.service;

import java.io.Serializable;

import com.java.spring.userservice.model.User;

public interface UserService extends Serializable {

	public User saveUser(User user);
}
