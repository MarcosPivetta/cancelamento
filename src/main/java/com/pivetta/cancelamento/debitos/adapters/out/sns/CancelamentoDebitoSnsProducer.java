package com.pivetta.cancelamento.debitos.adapters.out.sns;

import com.pivetta.cancelamento.debitos.adapters.out.sns.mapper.PayloadSnsMessageMapper;
import com.pivetta.cancelamento.debitos.application.core.domain.ResultadoCancelamento;
import com.pivetta.cancelamento.debitos.application.ports.out.PublicarCancelamentoOutputPort;
import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CancelamentoDebitoSnsProducer implements PublicarCancelamentoOutputPort {

    private final SnsTemplate snsTemplate;
    private final String topicoArn;
    private final PayloadSnsMessageMapper payloadSnsMessageMapper;

    public CancelamentoDebitoSnsProducer(
            SnsTemplate snsTemplate,
            @Value("${app.sns.topico-cancelamentos-arn}") String topicoArn, PayloadSnsMessageMapper payloadSnsMessageMapper) {
        this.snsTemplate = snsTemplate;
        this.topicoArn = topicoArn;
        this.payloadSnsMessageMapper = payloadSnsMessageMapper;
    }

    @Override
    public void publicar(ResultadoCancelamento resultadoCancelamento) {
        snsTemplate.convertAndSend(
                topicoArn,
                payloadSnsMessageMapper.toEventoCancelamentoSnsMessage(resultadoCancelamento));
    }
}
