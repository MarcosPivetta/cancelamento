package com.pivetta.cancelamento.debitos.application.ports.out;

import com.pivetta.cancelamento.debitos.application.core.domain.ResultadoCancelamento;

public interface PublicarCancelamentoOutputPort {
    void publicar(ResultadoCancelamento resultado);
}
