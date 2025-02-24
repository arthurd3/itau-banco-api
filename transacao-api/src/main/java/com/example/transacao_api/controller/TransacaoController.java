package com.example.transacao_api.controller;

import com.example.transacao_api.business.services.TransacaoService;
import com.example.transacao_api.controller.dtos.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Endpoint responsavel por adicionar  transacoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Transacao gravada com sucesso"),
            @ApiResponse(responseCode = "422" , description = "Campos nao atendem os requisitos da transacao"),
            @ApiResponse(responseCode = "400" , description = "Erro de requisicao"),
            @ApiResponse(responseCode = "500" , description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> adicionarTransao(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {

        transacaoService.adicionarTransacao(transacaoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    @Operation(description = "Endpoint responsavel por deletar  transacoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Transacao deletadas com sucesso"),
            @ApiResponse(responseCode = "400" , description = "Erro de requisicao"),
            @ApiResponse(responseCode = "500" , description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> removerTransacao() {
        transacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }
}
