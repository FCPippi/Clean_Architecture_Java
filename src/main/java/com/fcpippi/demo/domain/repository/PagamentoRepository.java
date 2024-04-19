package com.empresa.assinatura.domain.repository;

import com.fcpippi.demo.domain.entity.Pagamento;

public interface PagamentoRepository {
    Pagamento registrar(Pagamento pagamento);
}