package com.example.transacao_api.business.services;

import com.example.transacao_api.controller.dtos.EstatiticasResponseDTO;
import com.example.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatiticasResponseDTO calcularEstatiticasTransacoes(Integer intervaloBusca) {
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        // javaSTREAM PEGA A LISTA , E FAZ 1 POR 1 , ATE O FINAL DA LISTA..
        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        return new EstatiticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getMax(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getAverage());
    }
}
