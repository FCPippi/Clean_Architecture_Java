package com.fcpippi.demo.application.useCases;

import org.springframework.stereotype.Component;

import com.fcpippi.demo.application.dto.AplicativoDTO;
import com.fcpippi.demo.domain.service.AplicativoService;

@Component
public class AtualizaCustoMensalUC {
    private AplicativoService aplicativoService;

    public AtualizaCustoMensalUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public AplicativoDTO run(long codigoAplicativo, double custoMensal) {
        return AplicativoDTO.fromModel(this.aplicativoService.atualizarCusto(codigoAplicativo, custoMensal));
    }
}
