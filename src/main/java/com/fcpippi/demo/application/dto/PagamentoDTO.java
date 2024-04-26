package com.fcpippi.demo.application.dto;

import com.fcpippi.demo.domain.model.PagamentoModel;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private long codigo;
    private long codigoAssinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public static PagamentoDTO fromModel(PagamentoModel pagamento) {
        return new PagamentoDTO(
                pagamento.getCodigo(),
                pagamento.getAssinatura().getCodigo(),
                pagamento.getValorPago(),
                pagamento.getDataPagamento(),
                pagamento.getPromocao());
    }
}