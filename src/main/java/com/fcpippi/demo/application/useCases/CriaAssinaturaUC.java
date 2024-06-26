package com.fcpippi.demo.application.useCases;

import com.fcpippi.demo.application.dto.AssinaturaDTO;
import com.fcpippi.demo.domain.model.AssinaturaModel;
import com.fcpippi.demo.domain.service.AssinaturaService;

import org.springframework.stereotype.Component;

@Component
public class CriaAssinaturaUC {
    private AssinaturaService assinaturaService;

    public CriaAssinaturaUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public AssinaturaDTO run(long idCliente, long idAplicativ) {
        AssinaturaModel assinatura = assinaturaService.criarAssinatura(idCliente, idAplicativ);
        return AssinaturaDTO.fromModel(assinatura);
    }
}
