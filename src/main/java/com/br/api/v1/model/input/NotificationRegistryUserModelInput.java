package com.br.api.v1.model.input;

import javax.validation.constraints.*;

import lombok.*;

@Getter
@Setter
public class NotificationRegistryUserModelInput {

	@NotBlank
	@NotNull
    private String destinatario;

	@NotBlank
	@NotNull
	private String userLogin;
	
	@NotBlank
	@NotNull
	private String userPassword;
	
	@NotBlank
	@NotNull
	private String userName;
	
}
