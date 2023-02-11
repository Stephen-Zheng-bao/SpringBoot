package com.example.demo.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;





public class EmailTest {
	public static void main(String[] args) {
	
		
		//these steps are executed if an item is out of stock
		EmailConfig mail= new EmailConfig();
		JavaMailSender sender=mail.getJavaMailSender();
		SimpleMailMessage msg=mail.emailTemplate();
		sender.send(msg);
		//email.sendEmail(null, null, null);
	}

}
