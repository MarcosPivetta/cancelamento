package com.pivetta.cancelamento.debitos.config;

import com.pivetta.cancelamento.debitos.adapters.in.consumer.mapper.EventoDebitoMessageMapper;
import com.pivetta.cancelamento.debitos.application.core.mapper.ResultadoCancelamentoMapper;
import com.pivetta.cancelamento.debitos.application.core.domain.policy.PoliticaCancelamentoDebitoPort;
import com.pivetta.cancelamento.debitos.application.ports.in.CancelarDebitoInputPort;
import com.pivetta.cancelamento.debitos.application.ports.in.MarcarComoCanceladoInputPort;
import com.pivetta.cancelamento.debitos.application.ports.out.PublicarCancelamentoOutputPort;
import com.pivetta.cancelamento.debitos.application.usecases.CancelarDebitoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelarDebitoConfig {

    @Bean
    public CancelarDebitoInputPort portaDeEntradaCancelarDebito(
            PoliticaCancelamentoDebitoPort politicaCancelamentoDebitoPort,
            PublicarCancelamentoOutputPort publicarCancelamentoOutputPort,
            MarcarComoCanceladoInputPort marcarComoCanceladoInputPort,
            EventoDebitoMessageMapper debitoMapper,
            ResultadoCancelamentoMapper resultadoCancelamentoMapper) {
        return new CancelarDebitoUseCase(
                politicaCancelamentoDebitoPort,
                publicarCancelamentoOutputPort,
                marcarComoCanceladoInputPort,
                debitoMapper,
                resultadoCancelamentoMapper);
    }
}
