package com.fcpippi.demo.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoModel {
    private long codigo;
    private AssinaturaModel assinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;
}