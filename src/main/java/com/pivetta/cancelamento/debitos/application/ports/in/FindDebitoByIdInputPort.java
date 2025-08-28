package com.pivetta.cancelamento.debitos.application.ports.in;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;

public interface FindDebitoByIdInputPort {
    DebitoEntity findDebitoById(Long id);
}
