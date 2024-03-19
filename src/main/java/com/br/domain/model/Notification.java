package com.br.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

import com.br.api.exceptionhandler.StatusEmail;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TBL_EMAIL")
public class Notification implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
    private String destinatario;
	
    private String assunto;
    
    @Column(columnDefinition = "TEXT")
    private String corpo;
    
    @CreationTimestamp
    private LocalDateTime dateTime;
    
    @Enumerated(EnumType.STRING)
    private StatusEmail status;

}
