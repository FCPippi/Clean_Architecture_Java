package com.fcpippi.demo.infraestructure.persistence.jpa;

import com.fcpippi.demo.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoJpaRepository extends JpaRepository<Pagamento, Long> {
    // Métodos adicionais, se necessário
}