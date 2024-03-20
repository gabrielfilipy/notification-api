package com.br.api.v1.model.input;

import javax.validation.constraints.*;
import lombok.Data;

@Data
public class CodeValidationUserModelInput {
	
	@NotBlank
	@NotNull
	private String userName;
	
	@NotBlank
	@NotNull
    private String destinatario;
	
	private String codeValidation;

}
