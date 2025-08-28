package com.pivetta.cancelamento.debitos.adapters.in.consumer.mapper;

import com.pivetta.cancelamento.debitos.adapters.in.consumer.message.EventoDebitoMessage;
import com.pivetta.cancelamento.debitos.application.core.domain.model.Debito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoDebitoMessageMapper {

    Debito toDebito(EventoDebitoMessage eventoDebitoMessage);
}
