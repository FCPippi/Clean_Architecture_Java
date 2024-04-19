// PagamentoRepositoryImpl.java
package com.fcpippi.demo.infrastructure.database;

import com.fcpippi.demo.domain.entity.Pagamento;
import com.fcpippi.demo.domain.repository.PagamentoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PagamentoRepositoryImpl implements PagamentoRepository {
    private final PagamentoJpaRepository pagamentoJpaRepository;

    public PagamentoRepositoryImpl(PagamentoJpaRepository pagamentoJpaRepository) {
        this.pagamentoJpaRepository = pagamentoJpaRepository;
    }

    @Override
    public Pagamento registrar(Pagamento pagamento) {
        return pagamentoJpaRepository.save(pagamento);
    }
}