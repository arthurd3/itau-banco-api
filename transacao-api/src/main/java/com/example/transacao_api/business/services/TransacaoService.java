package com.example.transacao_api.business.services;

import com.example.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.example.transacao_api.infrastructure.exceptions.UnprocessebleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j //bliblioteca de logs
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacao = new ArrayList<>();

    public void adicionarTransacao(TransacaoRequestDTO dto) {

        log.info("iniciado o processamento de gravar transacoes");

        if(dto.dataTransacao().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessebleEntity("Data e Hora maiores que a data e hora atuais");
        }
        if(dto.valor() < 0){
            log.error("Valor negativo");
            throw new UnprocessebleEntity("Valor negativo");
        }
    }

}
