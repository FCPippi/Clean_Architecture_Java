package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.entity.Aplicativo;
import com.fcpippi.demo.domain.repository.AplicativoRepository;
import com.fcpippi.demo.infraestructure.persistence.jpa.AplicativoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class AplicativoRepositoryImpl implements AplicativoRepository {

    private final AplicativoJpaRepository repository;

    @Autowired
    public AplicativoRepositoryImpl(AplicativoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Aplicativo> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Aplicativo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void atualizarCusto(Long id, Double custo) {
        repository.atualizarCusto(id, custo);
    }
}