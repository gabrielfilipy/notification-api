package com.br.domain.service;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.br.Infrastructure.notify.email.SmtpEmail;
import com.br.api.exceptionhandler.StatusEmail;
import com.br.domain.model.Notification;
import com.br.domain.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	SmtpEmail smtpEmail;
	

	@Transactional
	public Notification sendEmail(Notification notificationModel) {
		notificationModel.setSendDateEmail(LocalDateTime.now());
		try { 
			smtpEmail.enviar(notificationModel);
			notificationModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			e.printStackTrace();
			notificationModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return notificationRepository.save(notificationModel);
		}
	}


}
