package com.fcpippi.demo.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaModel {
    private Long codigo;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
}