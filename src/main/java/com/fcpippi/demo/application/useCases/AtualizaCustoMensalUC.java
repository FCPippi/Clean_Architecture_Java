package com.fcpippi.demo.application.useCases;

import com.fcpippi.demo.application.dto.AplicativoDTO;
import com.fcpippi.demo.domain.service.AplicativoService;

public class AtualizaCustoMensalUC {
    private AplicativoService aplicativoService;

    public AtualizaCustoMensalUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public AplicativoDTO run(Long codigoAplicativo, Double custoMensal) {
        return AplicativoDTO.fromModel(this.aplicativoService.atualizarCusto(codigoAplicativo, custoMensal));
    }
}
