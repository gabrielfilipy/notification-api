package com.br.Infrastructure.notify.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.br.domain.model.Notification;

@Component
public class SmtpEmail {
	
	@Autowired
	JavaMailSender emailSender;
	
	public void enviar( Notification notificationModel) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(notificationModel.getEmailFrom());
		message.setTo(notificationModel.getEmailTo());
		message.setSubject(notificationModel.getSubject());
		message.setText(notificationModel.getText());
		emailSender.send(message);
	}
	

}
