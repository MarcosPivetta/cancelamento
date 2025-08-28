package com.pivetta.cancelamento.debitos.adapters.out.sns.mapper;

import com.pivetta.cancelamento.debitos.adapters.out.sns.message.EventoCancelamentoSnsMessage;
import com.pivetta.cancelamento.debitos.application.core.domain.ResultadoCancelamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PayloadSnsMessageMapper {

    EventoCancelamentoSnsMessage toEventoCancelamentoSnsMessage(ResultadoCancelamento resultadoCancelamento);
}
