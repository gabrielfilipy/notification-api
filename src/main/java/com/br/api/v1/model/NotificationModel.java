package com.br.api.v1.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
      @NotBlank
      @NotNull
	  private String text;

}
