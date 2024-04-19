package com.fcpippi.demo.domain.repository;

import com.fcpippi.demo.domain.entity.Aplicativo;

import java.util.List;

public interface AplicativoRepository {
    List<Aplicativo> buscarTodos();
    Aplicativo buscarPorId(Long id);
    void atualizarCusto(Long id, Double custo);
}