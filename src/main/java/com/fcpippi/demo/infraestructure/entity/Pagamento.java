package com.fcpippi.demo.infraestructure.entity;

import com.fcpippi.demo.domain.model.PagamentoModel;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @ManyToOne
    private Assinatura assinatura;
    
    private Double valorPago;
    
    private LocalDate dataPagamento;
    
    private String promocao;

    public static PagamentoModel toModel(Pagamento pagamento) {
        return new PagamentoModel(
            pagamento.getCodigo(),
            Assinatura.toModel(pagamento.getAssinatura()),
            pagamento.getValorPago(),
            pagamento.getDataPagamento(),
            pagamento.getPromocao()
        );
    }
}