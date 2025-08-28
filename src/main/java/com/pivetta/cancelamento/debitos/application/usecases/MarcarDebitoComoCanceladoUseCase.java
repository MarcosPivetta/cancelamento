package com.pivetta.cancelamento.debitos.application.usecases;

import com.pivetta.cancelamento.debitos.adapters.out.repository.entity.DebitoEntity;
import com.pivetta.cancelamento.debitos.adapters.out.repository.mapper.DebitoEntityMapper;
import com.pivetta.cancelamento.debitos.application.core.domain.model.StatusDebito;
import com.pivetta.cancelamento.debitos.application.ports.in.FindDebitoByIdInputPort;
import com.pivetta.cancelamento.debitos.application.ports.in.MarcarComoCanceladoInputPort;
import com.pivetta.cancelamento.debitos.application.ports.out.UpdateDebitoOutputPort;

public record MarcarDebitoComoCanceladoUseCase(
        FindDebitoByIdInputPort findDebitoByIdInputPort,
        UpdateDebitoOutputPort updateDebitoOutputPort,
        DebitoEntityMapper debitoEntityMapper) implements MarcarComoCanceladoInputPort {

    @Override
    public void marcarComoCancelado(Long idDebito) {
        DebitoEntity debitoEntity = findDebitoByIdInputPort.findDebitoById(idDebito);
        debitoEntity.setStatus(StatusDebito.CANCELADO);
        updateDebitoOutputPort.update(debitoEntity);
    }
}
