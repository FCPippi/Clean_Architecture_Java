package com.fcpippi.demo.infrastructure.persistence;

import com.fcpippi.demo.domain.entity.Aplicativo;
import com.fcpippi.demo.domain.repository.AplicativoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AplicativoRepositoryImpl implements AplicativoRepository {
    private final AplicativoJpaRepository aplicativoRepositoryJPA;

    public AplicativoRepositoryImpl(AplicativoJpaRepository aplicativoRepositoryJPA) {
        this.aplicativoRepositoryJPA = aplicativoRepositoryJPA;
    }

    @Override
    public List<Aplicativo> buscarTodos() {
        return aplicativoRepositoryJPA.findAll();
    }

    @Override
    public Aplicativo buscarPorId(Long id) {
        return aplicativoRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplicativo não encontrado"));
    }

    @Override
    public void atualizarCusto(Long id, Double custo) {
        aplicativoRepositoryJPA.atualizarCusto(id, custo);
    }
}