package com.br.domain.service.impl;

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
	public Notification sendEmail(Notification notification, String userName, String userLogin, String userPassword) {
		try {
			notification.setAssunto("Cadastro do usuário: " + userName.toUpperCase());
			var message = Message.builder()
					.assunto(notification.getAssunto())
					.corpo("registry-user.html")
					.variavel("USER_NAME", userName)
					.variavel("USER_LOGIN", userLogin)
					.variavel("USER_PASSWORD", userPassword)
					.destinatario(notification.getDestinatario()).build();

			notification.setCorpo(message.getCorpo());
			smtpEmail.enviar(message);
			notification.setStatus(StatusEmail.SENT);
		} catch (MailException e) {
			e.printStackTrace();
			notification.setStatus(StatusEmail.ERROR);
		} finally {
			return notificationRepository.save(notification);
		}
	}
	
	@Transactional
	public Notification codeValidation(Notification notification, String userName, String codeValidation ) {
		try {
			notification.setAssunto("Codigo de Segurança: " + codeValidation.toUpperCase());
			var message = Message.builder()
					.assunto(notification.getAssunto())
					.corpo("code-validation.html")
					.variavel("USER_NAME", userName)
					.variavel("CODE_VALIDATION", codeValidation)
					.destinatario(notification.getDestinatario()).build();

			notification.setCorpo(message.getCorpo());
			smtpEmail.enviar(message);
			notification.setStatus(StatusEmail.SENT);
		} catch (MailException e) {
			e.printStackTrace();
			notification.setStatus(StatusEmail.ERROR);
		} finally {
			return notificationRepository.save(notification);
		}
	}

}
