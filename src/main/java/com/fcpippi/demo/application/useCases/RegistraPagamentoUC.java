package com.fcpippi.demo.application.useCases;

import com.fcpippi.demo.domain.service.PagamentoService;

public class RegistraPagamentoUC {
    private PagamentoService pagamentoService;

    public RegistraPagamentoUC(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public Object run(String dia, String mes, String ano, Long codigoAssinatura, Double valorPago) {
        return this.pagamentoService.registrar(dia, mes, ano, codigoAssinatura, valorPago);
    }
}
