package com.pivetta.cancelamento.debitos.application.ports.out;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import java.util.Optional;

public interface FindDebitoByIdOutputPort {

    Optional<DebitoEntity> findDebitoById(Long id);
}
