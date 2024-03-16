package com.br.domain.service.impl;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.br.domain.service.NotificationService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.br.Infrastructure.notify.email.SmtpEmail;
import com.br.api.exceptionhandler.StatusEmail;
import com.br.domain.model.Notification;
import com.br.domain.repository.NotificationRepository;

@Service
public class NotificationServiceImpl {
	
	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	SmtpEmail smtpEmail;

	@Transactional
	public Notification sendEmail(Notification notificationModel, String userName, String userLogin, String userPassword) {
		notificationModel.setSendDateEmail(LocalDateTime.now());
		try {

			var message = Message.builder()
					.assunto(notificationModel.getSubject())
					.corpo("registry-user.html")
					.variavel("USER_NAME", userName)
					.variavel("USER_LOGIN", userLogin)
					.variavel("USER_PASSWORD", userPassword)
					.destinatario(notificationModel.getEmailTo()).build();

			smtpEmail.enviar(message);
			notificationModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			e.printStackTrace();
			notificationModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return notificationRepository.save(notificationModel);
		}
	}

}
