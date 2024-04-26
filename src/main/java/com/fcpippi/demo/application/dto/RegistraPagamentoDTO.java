package com.fcpippi.demo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistraPagamentoDTO {
    private String dia;
    private String mes;
    private String ano;
    private long codigoAssinatura;
    private double valorPago;
}