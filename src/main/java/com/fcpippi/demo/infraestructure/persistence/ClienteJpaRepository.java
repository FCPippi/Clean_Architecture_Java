package com.fcpippi.demo.infrastructure.persistence;

import com.fcpippi.demo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
}