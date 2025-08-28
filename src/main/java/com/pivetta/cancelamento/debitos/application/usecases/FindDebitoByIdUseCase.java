package com.pivetta.cancelamento.debitos.application.usecases;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import com.pivetta.cancelamento.debitos.application.ports.in.FindDebitoByIdInputPort;
import com.pivetta.cancelamento.debitos.application.ports.out.FindDebitoByIdOutputPort;

public record FindDebitoByIdUseCase(
        FindDebitoByIdOutputPort findDebitoByIdOutputPort) implements FindDebitoByIdInputPort {
    @Override
    public DebitoEntity findDebitoById(Long id) {
        return findDebitoByIdOutputPort.findDebitoById(id)
                .orElseThrow(() -> new RuntimeException("Débito não encontrado com id: " + id));
    }
}
