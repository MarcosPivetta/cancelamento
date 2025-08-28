package com.pivetta.cancelamento.debitos.application.ports.in;

public interface MarcarComoCanceladoInputPort {
    void marcarComoCancelado(Long idDebito);
}
