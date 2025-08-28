package com.pivetta.cancelamento.debitos.adapters.out;

import com.pivetta.cancelamento.debitos.adapters.out.repository.DebitoRepository;
import com.pivetta.cancelamento.debitos.adapters.out.repository.mapper.DebitoEntityMapper;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import com.pivetta.cancelamento.debitos.application.ports.out.SalvarDebitoOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarDebitoAdapter implements SalvarDebitoOutputPort {

    private final DebitoRepository debitoRepository;
    private final DebitoEntityMapper debitoEntityMapper;

    public SalvarDebitoAdapter(DebitoRepository debitoRepository, DebitoEntityMapper debitoEntityMapper) {
        this.debitoRepository = debitoRepository;
        this.debitoEntityMapper = debitoEntityMapper;
    }

    @Override
    public void salvar(Debito debito) {
        debitoRepository.save(debitoEntityMapper.toEntity(debito));
    }
}
