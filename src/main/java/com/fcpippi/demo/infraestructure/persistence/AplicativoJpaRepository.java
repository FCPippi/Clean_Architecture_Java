package com.fcpippi.demo.infrastructure.persistence;

import com.fcpippi.demo.domain.entity.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface AplicativoJpaRepository extends JpaRepository<Aplicativo, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Aplicativo a SET a.custoMensal = :custo WHERE a.codigo = :id")
    void atualizarCusto(@Param("id") Long id, @Param("custo") Double custo);
}