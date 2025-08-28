package com.pivetta.cancelamento.debitos.application.core.domain;

import java.math.BigDecimal;
import java.time.Instant;

public record DebitoSqsMessage(
    String idDebito,
    String idCliente,
    BigDecimal valor,
    String status,
    Instant criadoEm
) {}
