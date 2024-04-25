package com.fcpippi.demo.application.useCases;

import java.util.List;

import com.fcpippi.demo.application.dto.AssinaturaDTO;
import com.fcpippi.demo.domain.service.AssinaturaService;

public class ListaAssinaturaTipoUC {
    private AssinaturaService assinaturaService;

    public ListaAssinaturaTipoUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(String tipo) {
        return this.assinaturaService.buscarPorTipo(tipo).stream()
                .map(assinatura -> AssinaturaDTO.fromModel(assinatura)).toList();
    }
}
