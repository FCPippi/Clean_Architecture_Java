package com.fcpippi.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AplicativoModel {
    private Long codigo;
    private String nome;
    private Double custoMensal;
}