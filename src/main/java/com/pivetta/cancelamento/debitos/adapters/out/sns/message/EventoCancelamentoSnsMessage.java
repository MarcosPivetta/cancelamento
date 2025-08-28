package com.pivetta.cancelamento.debitos.adapters.out.sns.message;

public record EventoCancelamentoSnsMessage(
    String idDebito,
    String idCliente,
    boolean cancelado,
    String motivo
) {}
