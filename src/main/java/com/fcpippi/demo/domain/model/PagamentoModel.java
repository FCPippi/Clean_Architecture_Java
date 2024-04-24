package com.fcpippi.demo.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoModel {
    private Long codigo;
    private AssinaturaModel assinatura;
    private Double valorPago;
    private LocalDate dataPagamento;
    private String promocao;
}