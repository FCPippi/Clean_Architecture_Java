package com.fcpippi.demo.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fcpippi.demo.infraestructure.entity.Assinatura;


public interface AssinaturaJpaRepository extends JpaRepository<Assinatura, Long> {}