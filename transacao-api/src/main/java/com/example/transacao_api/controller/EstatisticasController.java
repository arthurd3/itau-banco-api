package com.example.transacao_api.controller;

import com.example.transacao_api.business.services.EstatisticasService;
import com.example.transacao_api.controller.dtos.EstatiticasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    public ResponseEntity<EstatiticasResponseDTO> buscarEstatisticas(@RequestParam(value = "intervaloBusca" , required = false , defaultValue = "60") Integer intervaloBusca) {
        return ResponseEntity.ok(estatisticasService.calcularEstatiticasTransacoes(intervaloBusca));
    }

}
