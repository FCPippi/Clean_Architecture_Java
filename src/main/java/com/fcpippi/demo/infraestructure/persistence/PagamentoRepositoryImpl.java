// PagamentoRepositoryImpl.java
package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.entity.Pagamento;
import com.fcpippi.demo.domain.repository.PagamentoRepository;
import com.fcpippi.demo.infraestructure.persistence.jpa.PagamentoJpaRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
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