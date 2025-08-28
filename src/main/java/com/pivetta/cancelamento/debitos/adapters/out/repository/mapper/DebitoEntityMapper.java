package com.pivetta.cancelamento.debitos.adapters.out.repository.mapper;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DebitoEntityMapper {

    DebitoEntity toEntity(Debito debito);

    Debito toDebito(DebitoEntity debitoEntity);
}
