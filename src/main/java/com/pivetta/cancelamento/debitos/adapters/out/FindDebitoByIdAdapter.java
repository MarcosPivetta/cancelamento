package com.pivetta.cancelamento.debitos.adapters.out;

import com.pivetta.cancelamento.debitos.adapters.out.repository.DebitoRepository;
import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import com.pivetta.cancelamento.debitos.application.ports.out.FindDebitoByIdOutputPort;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FindDebitoByIdAdapter implements FindDebitoByIdOutputPort {

    private final DebitoRepository debitoRepository;

    public FindDebitoByIdAdapter(
            DebitoRepository debitoRepository) {
        this.debitoRepository = debitoRepository;
    }

    @Override
    public Optional<DebitoEntity> findDebitoById(Long id) {
        return debitoRepository.findById(id);
    }
}
