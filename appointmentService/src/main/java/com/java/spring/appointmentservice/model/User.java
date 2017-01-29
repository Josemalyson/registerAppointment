package com.java.spring.appointmentservice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1415136941390961939L;

	private Long id;

	private String name;

	private String cpf;

}
