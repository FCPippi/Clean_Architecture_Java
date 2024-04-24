package com.fcpippi.demo.domain.repository;

import com.fcpippi.demo.infraestructure.entity.Pagamento;

public interface PagamentoRepository {
    Pagamento registrar(Pagamento pagamento);
}