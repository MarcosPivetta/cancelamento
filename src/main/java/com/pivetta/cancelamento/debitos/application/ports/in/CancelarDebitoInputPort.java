package com.pivetta.cancelamento.debitos.application.ports.in;

import com.pivetta.cancelamento.debitos.application.core.domain.ResultadoCancelamento;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;

public interface CancelarDebitoInputPort {
    ResultadoCancelamento executar(Debito debito);
}
