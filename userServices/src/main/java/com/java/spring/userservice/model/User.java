package com.java.spring.userservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Table(name = "TB_USER")
@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1415136941393461939L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "DS_NAME")
	private String name;

	@CPF
	@Column(name = "cpf")
	private String cpf;

}
