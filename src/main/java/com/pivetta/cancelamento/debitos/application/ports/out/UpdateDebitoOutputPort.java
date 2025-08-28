package com.pivetta.cancelamento.debitos.application.ports.out;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;

public interface UpdateDebitoOutputPort {
    void update(DebitoEntity debitoEntity);
}
