package com.pivetta.cancelamento.debitos.adapters.out;

import com.pivetta.cancelamento.debitos.adapters.out.repository.DebitoRepository;
import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import com.pivetta.cancelamento.debitos.application.ports.out.UpdateDebitoOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateDebitoAdapter implements UpdateDebitoOutputPort {

    private final DebitoRepository debitoRepository;

    public UpdateDebitoAdapter(DebitoRepository debitoRepository) {
        this.debitoRepository = debitoRepository;
    }

    @Override
    public void update(DebitoEntity debitoEntity) {
        debitoRepository.save(debitoEntity);
    }
}
