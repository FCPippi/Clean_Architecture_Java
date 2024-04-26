package com.fcpippi.demo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private long codigoAssinatura;
    private double valorPago;
    private int dia;
    private int mes;
    private int ano;
    private String promocao;
}