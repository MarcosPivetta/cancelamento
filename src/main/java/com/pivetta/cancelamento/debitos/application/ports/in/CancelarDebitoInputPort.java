package com.pivetta.cancelamento.debitos.application.ports.in;

import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;

public interface CancelarDebitoInputPort {
    void executar(Debito debito);
}
