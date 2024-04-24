package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.domain.model.ClienteModel;

public interface ClienteRepository {
    List<ClienteModel> buscarTodos();
    ClienteModel buscaPorId(Long id);
}
