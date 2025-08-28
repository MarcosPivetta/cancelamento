package com.pivetta.cancelamento.debitos.application.core.domain.policy;

import com.pivetta.cancelamento.debitos.application.core.domain.model.DecisaoCancelamento;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;

public interface PoliticaCancelamentoDebitoPort {
    DecisaoCancelamento podeCancelar(Debito debito);
}
