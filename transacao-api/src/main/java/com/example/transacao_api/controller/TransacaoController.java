package com.example.transacao_api.controller;

import com.example.transacao_api.business.services.TransacaoService;
import com.example.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;


    @PostMapping
    public ResponseEntity<Void> adicionarTransao(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {

        transacaoService.adicionarTransacao(transacaoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    public ResponseEntity<Void> removerTransacao() {
        transacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }
}
