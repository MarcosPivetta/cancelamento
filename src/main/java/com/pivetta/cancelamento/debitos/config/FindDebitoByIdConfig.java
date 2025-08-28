package com.pivetta.cancelamento.debitos.config;

import com.pivetta.cancelamento.debitos.adapters.out.FindDebitoByIdAdapter;
import com.pivetta.cancelamento.debitos.application.usecases.FindDebitoByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindDebitoByIdConfig {

    @Bean
    public FindDebitoByIdUseCase findDebitoByIdUseCase(
            FindDebitoByIdAdapter findDebitoByIdAdapter) {
        return new FindDebitoByIdUseCase(findDebitoByIdAdapter);
    }
}
