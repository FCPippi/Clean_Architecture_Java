package com.fcpippi.demo.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcpippi.demo.infraestructure.entity.Cliente;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
}