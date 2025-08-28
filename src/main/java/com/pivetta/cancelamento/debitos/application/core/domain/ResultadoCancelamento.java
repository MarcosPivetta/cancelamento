package com.pivetta.cancelamento.debitos.application.core.domain;

public record ResultadoCancelamento(
    String idDebito,
    String idCliente,
    boolean cancelado,
    String motivo
) {}
