package com.fcpippi.demo.application.dto;

import com.fcpippi.demo.domain.model.Aplicativo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoDTO {
    private Long codigo;
    private String nome;
    private Double custoMensal;

    public static AplicativoDTO fromModel(Aplicativo aplicativo) {
        return new AplicativoDTO(
            aplicativo.getCodigo(),
            aplicativo.getNome(),
            aplicativo.getCustoMensal()
        );
    }
}