package com.fcpippi.demo.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcpippi.demo.infraestructure.entity.Pagamento;

public interface PagamentoJpaRepository extends JpaRepository<Pagamento, Long> {
    // Métodos adicionais, se necessário
}