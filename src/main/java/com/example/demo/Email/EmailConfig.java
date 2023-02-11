package com.example.demo.Email;


	import java.util.Properties;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.mail.javamail.JavaMailSender;
	import org.springframework.mail.javamail.JavaMailSenderImpl;

	@Configuration
	public class EmailConfig
	{
		@Bean
		public JavaMailSender getJavaMailSender()
		{
		    JavaMailSender sendMail = new JavaMailSenderImpl();
		    ((JavaMailSenderImpl) sendMail).setHost("smtp.gmail.com");
		    ((JavaMailSenderImpl) sendMail).setPort(25);

		    ((JavaMailSenderImpl) sendMail).setUsername("statusjewellery4@gmail.com");
		    ((JavaMailSenderImpl) sendMail).setPassword("mmnaukpzndyezadh");

		    Properties properties = ((JavaMailSenderImpl) sendMail).getJavaMailProperties();
		    properties.put("mail.transport.protocol", "smtp");
		    properties.put("mail.smtp.auth", "true");
		    properties.put("mail.smtp.starttls.enable", "true");
		    properties.put("mail.debug", "true");

		    return sendMail;
		}

		@Bean
		public SimpleMailMessage emailLayout()
		{
			//this method will be called if an item is out of stock. pass the name of the item that's out of stock,
			//as a parameter, so we let users know which item it is
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo("rigodonamariah20@gmail.com"); //who to send email to? Pass "to" as a parameter if it's gonna be different everytime? should be automatic though, so maybe just hardcode to send email to admin?
			msg.setFrom("statusjewellery4@gmail.com");
			msg.setSubject("Stock alert");
			msg.setText("Item is out of stock !!"); //need to state name of item
		    return msg;
		}
	}
	

