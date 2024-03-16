package com.br.api.v1.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Singular;

import java.util.Map;

@Data
public class NotificationModel {
	
	  @NotBlank
      @NotNull
	  private String ownerRef;
      @NotBlank
      @NotNull
      @Email
	  private String emailFrom;
      @NotBlank
      @NotNull
      @Email
	  private String emailTo;
      @NotBlank
      @NotNull
	  private String subject;
      private String text;

    @Singular("variavel")
    private Map<String, Object> variaveis;

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
