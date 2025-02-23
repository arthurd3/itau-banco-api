package com.example.transacao_api.infrastructure.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessebleEntity extends RuntimeException {
    public UnprocessebleEntity(String message) {
        super(message);
    }

    //Entidade Improcessável ( UnprocessebleEntity )

    //indicar que a solicitação feita não pode ser processada devido a erros de dados ou formato inválido.
}
