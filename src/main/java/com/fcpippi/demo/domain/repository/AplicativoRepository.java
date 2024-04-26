package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.domain.model.AplicativoModel;

public interface AplicativoRepository {
    List<AplicativoModel> buscarTodos();

    AplicativoModel buscarPorId(long id);

    AplicativoModel atualizarCusto(long id, double custo);
}