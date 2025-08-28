package com.pivetta.cancelamento.debitos.config;

import com.pivetta.cancelamento.debitos.adapters.out.repository.mapper.DebitoEntityMapper;
import com.pivetta.cancelamento.debitos.application.ports.in.FindDebitoByIdInputPort;
import com.pivetta.cancelamento.debitos.application.ports.in.MarcarComoCanceladoInputPort;
import com.pivetta.cancelamento.debitos.application.ports.out.UpdateDebitoOutputPort;
import com.pivetta.cancelamento.debitos.application.usecases.FindDebitoByIdUseCase;
import com.pivetta.cancelamento.debitos.application.usecases.MarcarDebitoComoCanceladoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarcarComoCanceladoConfig {

    @Bean
    public MarcarComoCanceladoInputPort marcarComoCancelado(
            FindDebitoByIdUseCase findDebitoByIdUseCase,
            UpdateDebitoOutputPort updateDebitoOutputPort,
            DebitoEntityMapper debitoEntityMapper
    ) {
        return new MarcarDebitoComoCanceladoUseCase(
                findDebitoByIdUseCase,
                updateDebitoOutputPort,
                debitoEntityMapper);
    }
}
