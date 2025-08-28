package com.pivetta.cancelamento.debitos.application.usecases;

import com.pivetta.cancelamento.debitos.adapters.in.consumer.mapper.EventoDebitoMessageMapper;
import com.pivetta.cancelamento.debitos.application.core.domain.DebitoSqsMessage;
import com.pivetta.cancelamento.debitos.application.core.domain.ResultadoCancelamento;
import com.pivetta.cancelamento.debitos.application.core.mapper.ResultadoCancelamentoMapper;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import com.pivetta.cancelamento.debitos.application.core.domain.model.DecisaoCancelamento;
import com.pivetta.cancelamento.debitos.application.core.domain.policy.PoliticaCancelamentoDebitoPort;
import com.pivetta.cancelamento.debitos.application.ports.in.CancelarDebitoInputPort;
import com.pivetta.cancelamento.debitos.application.ports.in.MarcarComoCanceladoInputPort;
import com.pivetta.cancelamento.debitos.application.ports.out.PublicarCancelamentoOutputPort;

public record CancelarDebitoUseCase(
        PoliticaCancelamentoDebitoPort politicaCancelamentoDebito,
        PublicarCancelamentoOutputPort publicarCancelamentoOutputPort,
        MarcarComoCanceladoInputPort marcarComoCanceladoInputPort,
        EventoDebitoMessageMapper debitoMapper,
        ResultadoCancelamentoMapper resultadoCancelamentoMapper) implements CancelarDebitoInputPort {

    @Override
    public ResultadoCancelamento executar(Debito debito) {
        var decisao = politicaCancelamentoDebito.podeCancelar(debito);
        marcaDebitoComoCancelado(decisao, debito);
        ResultadoCancelamento resultadoCancelamento = resultadoCancelamentoMapper.toResultadoCancelamento(debito, decisao);
        publicarCancelamentoOutputPort.publicar(resultadoCancelamento);
        return resultadoCancelamento;
    }

    private void marcaDebitoComoCancelado(DecisaoCancelamento decisao, Debito debito) {
        if (decisao.status()) {
            marcarComoCanceladoInputPort.marcarComoCancelado(debito.idDebito());
        }
    }
}
