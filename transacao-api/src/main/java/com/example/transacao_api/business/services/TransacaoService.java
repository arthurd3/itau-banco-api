package com.example.transacao_api.business.services;

import com.example.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.example.transacao_api.infrastructure.exceptions.UnprocessebleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

        listaTransacao.add(dto);
    }

    public void limparTransacao() {
        listaTransacao.clear();
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){
        OffsetDateTime dataBusca = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return listaTransacao.stream().filter(transacao -> transacao.dataTransacao().isAfter(dataBusca)).toList();

        // 1- chama a lista de transacao ( listaTransacao )
        // 2- chama o javaStream para filtrar ( stream() )
        // 3- ele vai filtrar cada uma das transacao ( filter() )
        // 4- e verifica se a data e hora e posterior a data e hora do intervalo ( transacao.dataTransacao().isAfter(dataBusca) )
        // 5- se for posterior ele adiciona a lista ( .toList() )
    }

}
