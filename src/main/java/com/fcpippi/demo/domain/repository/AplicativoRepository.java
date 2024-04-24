package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.infraestructure.entity.Aplicativo;

public interface AplicativoRepository {
    List<Aplicativo> buscarTodos();
    Aplicativo buscarPorId(Long id);
    void atualizarCusto(Long id, Double custo);
}