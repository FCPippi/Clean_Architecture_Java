package com.fcpippi.demo.infraestructure.entity;

import com.fcpippi.demo.domain.model.AplicativoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    private String nome;
    
    private Double custoMensal;

    public static AplicativoModel toModel(Aplicativo aplicativo) {
        return new AplicativoModel(
            aplicativo.getCodigo(),
            aplicativo.getNome(),
            aplicativo.getCustoMensal()
        );
    }

    public static Aplicativo fromModel(AplicativoModel aplicativoModel) {
        return new Aplicativo(
            aplicativoModel.getCodigo(),
            aplicativoModel.getNome(),
            aplicativoModel.getCustoMensal()
        );
    }
}