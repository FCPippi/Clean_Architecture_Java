package com.fcpippi.demo.infraestructure.persistence.jpa;

import com.fcpippi.demo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
}