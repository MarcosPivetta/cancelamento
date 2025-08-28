package com.pivetta.cancelamento.debitos.adapters.out.repository;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DebitoRepository extends CrudRepository<DebitoEntity, Long> {
}
