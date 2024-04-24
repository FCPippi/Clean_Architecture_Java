package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.domain.model.AplicativoModel;

public interface AplicativoRepository {
    List<AplicativoModel> buscarTodos();
    AplicativoModel buscarPorId(Long id);
    AplicativoModel atualizarCusto(Long id, Double custo);
}