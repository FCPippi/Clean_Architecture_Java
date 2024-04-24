package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.infraestructure.entity.Cliente;

public interface ClienteRepository {
    List<Cliente> buscarTodos();
}
