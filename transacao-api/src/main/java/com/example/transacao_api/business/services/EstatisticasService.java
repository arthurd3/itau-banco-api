package com.example.transacao_api.business.services;

import com.example.transacao_api.controller.dtos.EstatiticasResponseDTO;
import com.example.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatiticasResponseDTO calcularEstatiticasTransacoes(Integer intervaloBusca) {

        log.info("Iniciada busca de estatisticas de Transacoes com o periodo de tempo " + intervaloBusca);

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        if(transacoes.isEmpty()) {
            return new EstatiticasResponseDTO(0L , 0.0 , 0.0 ,0.0 , 0.0);
        }

        // javaSTREAM PEGA A LISTA , E FAZ 1 POR 1 , ATE O FINAL DA LISTA..
        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        log.info("Estatisticas retornadas com sucesso");

        return new EstatiticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getMax(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getAverage());
    }
}
