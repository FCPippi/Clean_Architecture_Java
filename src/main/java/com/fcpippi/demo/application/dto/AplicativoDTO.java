package com.fcpippi.demo.application.dto;

import com.fcpippi.demo.domain.model.AplicativoModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoDTO {
    private long codigo;
    private String nome;
    private double custoMensal;

    public static AplicativoDTO fromModel(AplicativoModel aplicativo) {
        return new AplicativoDTO(
                aplicativo.getCodigo(),
                aplicativo.getNome(),
                aplicativo.getCustoMensal());
    }
}