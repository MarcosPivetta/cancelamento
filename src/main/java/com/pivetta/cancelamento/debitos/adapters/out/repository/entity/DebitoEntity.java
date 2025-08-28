package com.pivetta.cancelamento.debitos.adapters.out.repository.entity;

import com.pivetta.cancelamento.debitos.application.core.domain.model.StatusDebito;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
public class DebitoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String idDebito;
    private String idCliente;
    private BigDecimal valor;
    private StatusDebito status;
    private Instant criadoEm;
}
