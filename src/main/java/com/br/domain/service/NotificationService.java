package com.br.domain.service;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.*;

public interface NotificationService {

    void enviar(Message message);

    @Getter
    @Builder
    class Message {

        @Singular
        private Set<String> destinatarios;

        @NotNull
        private String assunto;

        @NotNull
        private String corpo;

        @Singular("variavel")
        private Map<String, Object> variaveis;

    }

}
