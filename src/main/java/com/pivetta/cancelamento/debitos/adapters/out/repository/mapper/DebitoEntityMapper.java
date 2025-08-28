package com.pivetta.cancelamento.debitos.adapters.out.repository.mapper;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DebitoEntityMapper {

    @Mapping(target = "id", ignore = true)
    DebitoEntity toEntity(Debito debito);

    Debito toDebito(DebitoEntity debitoEntity);
}
