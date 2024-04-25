package com.fcpippi.demo.application.dto;

import com.fcpippi.demo.domain.model.AssinaturaModel;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaDTO {
    private Long codigo;
    private Long codigoAplicativo;
    private Long codigoCliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String tipo;

    public static AssinaturaDTO fromModel(AssinaturaModel assinatura) {
        return new AssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getAplicativo().getCodigo(),
                assinatura.getCliente().getCodigo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                assinatura.getTipo());
    }
}