package com.pivetta.cancelamento.debitos.application.core.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public record Debito(
    Long idDebito,
    String idCliente,
    BigDecimal valor,
    StatusDebito status,
    Instant criadoEm
) {}
