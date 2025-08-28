package com.pivetta.cancelamento.debitos.application.core.mapper;

import com.pivetta.cancelamento.debitos.application.core.domain.ResultadoCancelamento;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import com.pivetta.cancelamento.debitos.application.core.domain.model.DecisaoCancelamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResultadoCancelamentoMapper {

    @Mapping(target = "cancelado", source = "decisaoCancelamento.status")
    ResultadoCancelamento toResultadoCancelamento(Debito debito, DecisaoCancelamento decisaoCancelamento);
}
