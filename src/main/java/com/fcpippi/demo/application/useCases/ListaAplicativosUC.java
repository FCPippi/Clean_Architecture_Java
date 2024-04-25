package com.fcpippi.demo.application.useCases;

import java.util.List;

import com.fcpippi.demo.application.dto.AplicativoDTO;
import com.fcpippi.demo.domain.service.AplicativoService;

public class ListaAplicativosUC {
    private AplicativoService aplicativoService;

    public ListaAplicativosUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public List<AplicativoDTO> run() {
        return this.aplicativoService.buscarTodos().stream().map(aplicativo -> AplicativoDTO.fromModel(aplicativo))
                .toList();
    }
}
