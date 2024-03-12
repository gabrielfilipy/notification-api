package com.br.domain.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.br.api.exceptionhandler.StatusEmail;
import lombok.Data;


@Data
@Entity
@Table(name = "TBL_EMAIL")
public class Notification implements Serializable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
