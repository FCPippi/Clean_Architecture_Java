package com.fcpippi.demo.application.useCases;

import java.util.List;

import com.fcpippi.demo.application.dto.AssinaturaDTO;
import com.fcpippi.demo.domain.service.AssinaturaService;
import org.springframework.stereotype.Component;

@Component
public class ListaAssinaturaAplicativoUC {
    private AssinaturaService assinaturaService;

    public ListaAssinaturaAplicativoUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(long codigoAplicativo) {
        return this.assinaturaService.buscarPorAplicativo(codigoAplicativo).stream()
                .map(assinatura -> AssinaturaDTO.fromModel(assinatura)).toList();
    }
}
