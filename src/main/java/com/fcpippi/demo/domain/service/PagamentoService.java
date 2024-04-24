package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.repository.PagamentoRepository;
import com.fcpippi.demo.infraestructure.entity.Pagamento;

import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento registrar(Pagamento pagamento) {
        return pagamentoRepository.registrar(pagamento);
    }
}