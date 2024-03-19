package com.br.Infrastructure.notify.email;

import com.br.domain.service.NotificationService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;

@Component
public class SmtpEmail implements NotificationService {
	
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private Configuration configurationFremaker;

	@Value("${spring.mail.username}")
	private String remetente;

	private String processarTemplate(Message message) {
		try {
			Template template = configurationFremaker.getTemplate(message.getCorpo());
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, message.getVariaveis());
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public void enviar(Message message) {
		try {
			String corpo = processarTemplate(message);
			MimeMessage mimeMessage = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setFrom(remetente);
			helper.setTo(message.getDestinatarios().toArray(new String[0]));
			helper.setSubject(message.getAssunto());
			helper.setText(corpo, true);
			emailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new RuntimeException("Houve um erro ao tentar enviar o E-mail.");
		}
	}
}
