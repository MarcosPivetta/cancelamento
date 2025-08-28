package com.pivetta.cancelamento.debitos.adapters.in.consumer.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

public record EventoDebitoMessage(
    @NotBlank String idDebito,
    @NotBlank String idCliente,
    @NotNull BigDecimal valor,
    @NotBlank String status,
    @NotNull Instant criadoEm
) {}
