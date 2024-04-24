package com.fcpippi.demo.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fcpippi.demo.infraestructure.entity.Aplicativo;


public interface AplicativoJpaRepository extends JpaRepository<Aplicativo, Long> {}