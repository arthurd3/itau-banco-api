package com.example.transacao_api.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(double valor , OffsetDateTime dataTransacao) {
}
