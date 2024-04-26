package com.fcpippi.demo.application.useCases;

import java.util.List;

import com.fcpippi.demo.application.dto.AssinaturaDTO;
import com.fcpippi.demo.domain.service.AssinaturaService;
import org.springframework.stereotype.Component;

@Component
public class ListaAssinaturaClienteUC {
    private AssinaturaService assinaturaService;

    public ListaAssinaturaClienteUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(long codigoCliente) {
        return this.assinaturaService.buscarPorCliente(codigoCliente).stream()
                .map(assinatura -> AssinaturaDTO.fromModel(assinatura)).toList();
    }
}
