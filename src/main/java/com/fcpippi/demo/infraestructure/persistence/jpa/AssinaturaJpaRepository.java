package com.fcpippi.demo.infraestructure.persistence.jpa;

import com.fcpippi.demo.domain.entity.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssinaturaJpaRepository extends JpaRepository<Assinatura, Long> {
    @Query("SELECT a FROM Assinatura a WHERE a.cliente.codigo = :codigoCliente")
    List<Assinatura> buscarPorCliente(@Param("codigoCliente") Long codigoCliente);

    @Query("SELECT a FROM Assinatura a WHERE a.aplicativo.codigo = :codigoAplicativo")
    List<Assinatura> buscarPorAplicativo(@Param("codigoAplicativo") Long codigoAplicativo);

}