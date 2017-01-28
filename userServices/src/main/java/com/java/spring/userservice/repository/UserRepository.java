package com.java.spring.userservice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.userservice.model.User;

public interface UserRepository extends Serializable, JpaRepository<User, Long> {

}
