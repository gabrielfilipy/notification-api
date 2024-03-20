package com.br.api.v1.controller;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.br.api.v1.model.input.*;
import com.br.domain.model.Notification;
import com.br.domain.service.impl.NotificationServiceImpl;
import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/v1/notification")
public class NotificationController {
	
	@Autowired
	NotificationServiceImpl notificationServiceImpl;
	
	@PostMapping("/registry-user")
	public ResponseEntity<Notification> registruUser(@RequestBody @Valid NotificationRegistryUserModelInput notificationModel) {
		Notification notification = new Notification(); 
		BeanUtils.copyProperties(notificationModel, notification);
		notificationServiceImpl.sendEmail(notification, notificationModel.getUserName(),
				notificationModel.getUserLogin(), notificationModel.getUserPassword());
		return new ResponseEntity<>(notification, HttpStatus.CREATED);
	}
	
	@PostMapping("/code-validation")
	public ResponseEntity<Notification> codeValidation(@RequestBody @Valid CodeValidationUserModelInput notificationModel) {
		Notification notification = new Notification(); 
		BeanUtils.copyProperties(notificationModel, notification);
		notificationServiceImpl.codeValidation(notification, notificationModel.getUserName(),
				notificationModel.getCodeValidation());
		return new ResponseEntity<>(notification, HttpStatus.CREATED);
	}


}
