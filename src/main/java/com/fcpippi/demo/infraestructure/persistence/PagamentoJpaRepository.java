package com.fcpippi.demo.infrastructure.database;

import com.fcpippi.demo.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PagamentoJpaRepository extends JpaRepository<Pagamento, Long> {
    // Métodos adicionais, se necessário
}