package com.java.spring.appointmentservice.config;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class SimpleMailMessageConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4865988124578459052L;

	@Value("${spring.mail.host}")
	private String host;
	@Value("${spring.mail.port}")
	private int port;
	@Value("${spring.mail.password}")
	private String password;
	@Value("${spring.mail.username}")
	private String username;
	@Value("${spring.mail.protocol}")
	private String protocol;
	@Value("${spring.mail.default-encoding}")
	private String encoding;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setProtocol(protocol);
		mailSender.setDefaultEncoding(encoding);
		Session session = Session.getInstance(mailProps(), new GmailAuthenticator(username, password));
		mailSender.setSession(session);
		return mailSender;
	}

	private Properties mailProps() {
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		return properties;
	}
}
