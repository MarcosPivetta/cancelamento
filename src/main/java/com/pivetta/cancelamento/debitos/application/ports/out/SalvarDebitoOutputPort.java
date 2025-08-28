package com.pivetta.cancelamento.debitos.application.ports.out;

import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;

public interface SalvarDebitoOutputPort {
    void salvar(Debito debito);
}
