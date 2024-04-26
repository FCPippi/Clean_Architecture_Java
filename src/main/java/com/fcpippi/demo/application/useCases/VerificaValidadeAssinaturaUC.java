package com.fcpippi.demo.application.useCases;

import com.fcpippi.demo.domain.service.AssinaturaService;
import org.springframework.stereotype.Component;

@Component
public class VerificaValidadeAssinaturaUC {
    private AssinaturaService assinaturaService;

    public VerificaValidadeAssinaturaUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public boolean run(Long codigoAssinatura) {
        return this.assinaturaService.assinaturaValida(codigoAssinatura);
    }
}
