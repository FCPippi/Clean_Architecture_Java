package com.fcpippi.demo.domain.repository;

import com.fcpippi.demo.domain.entity.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> buscarTodos();
}
