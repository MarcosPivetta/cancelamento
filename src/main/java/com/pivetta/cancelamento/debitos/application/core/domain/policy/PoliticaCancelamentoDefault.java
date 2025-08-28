package com.pivetta.cancelamento.debitos.application.core.domain.policy;

import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import com.pivetta.cancelamento.debitos.application.core.domain.model.DecisaoCancelamento;
import com.pivetta.cancelamento.debitos.application.core.domain.model.StatusDebito;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

public class PoliticaCancelamentoDefault implements PoliticaCancelamentoDebitoPort {

    @Override
    public DecisaoCancelamento podeCancelar(Debito debito) {
        if (debito.status() != StatusDebito.PENDENTE)
            return DecisaoCancelamento.negado("STATUS_NAO_PENDENTE");

        if (debito.valor().compareTo(new BigDecimal("1000.00")) > 0)
            return DecisaoCancelamento.negado("VALOR_ACIMA_DO_LIMITE");

        if (Duration.between(debito.criadoEm(), Instant.now()).toHours() > 48)
            return DecisaoCancelamento.negado("MAIOR_QUE_48H");

        return DecisaoCancelamento.aprovado();
    }
}
