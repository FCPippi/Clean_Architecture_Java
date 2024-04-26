package com.fcpippi.demo.application.useCases;

import com.fcpippi.demo.domain.service.PagamentoService;
import org.springframework.stereotype.Component;

@Component
public class RegistraPagamentoUC {
    private PagamentoService pagamentoService;

    public RegistraPagamentoUC(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public Object run(String dia, String mes, String ano, long codigoAssinatura, double valorPago) {
        return this.pagamentoService.registrar(dia, mes, ano, codigoAssinatura, valorPago);
    }
}
