package com.pivetta.cancelamento.debitos.adapters.in.consumer;

import com.pivetta.cancelamento.debitos.adapters.in.consumer.mapper.EventoDebitoMessageMapper;
import com.pivetta.cancelamento.debitos.adapters.in.consumer.message.EventoDebitoMessage;
import com.pivetta.cancelamento.debitos.application.ports.in.CancelarDebitoInputPort;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.validation.Valid;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CancelamentoDebitoSqsConsumer {

    private final CancelarDebitoInputPort cancelarDebitoInputPort;
    private final EventoDebitoMessageMapper eventoDebitoMessageMapper;

    public CancelamentoDebitoSqsConsumer(CancelarDebitoInputPort cancelarDebitoInputPort, EventoDebitoMessageMapper eventoDebitoMessageMapper) {
        this.cancelarDebitoInputPort = cancelarDebitoInputPort;
        this.eventoDebitoMessageMapper = eventoDebitoMessageMapper;
    }

    @SqsListener("${app.sqs.fila-debitos}")
    public void onMessage(@Valid @Payload EventoDebitoMessage eventoDebitoMessage) {
        cancelarDebitoInputPort.executar(eventoDebitoMessageMapper.toDebito(eventoDebitoMessage));
    }
}
