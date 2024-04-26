package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.repository.PagamentoRepository;

import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Object registrar(String dia, String mes, String ano, long codigoAssinatura, double valorPago) {
        return pagamentoRepository.registrar(dia, mes, ano, codigoAssinatura, valorPago);
    }
}