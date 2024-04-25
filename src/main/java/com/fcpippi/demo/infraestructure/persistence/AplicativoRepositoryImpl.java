package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.model.AplicativoModel;
import com.fcpippi.demo.domain.repository.AplicativoRepository;
import com.fcpippi.demo.infraestructure.entity.Aplicativo;
import com.fcpippi.demo.infraestructure.persistence.jpa.AplicativoJpaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class AplicativoRepositoryImpl implements AplicativoRepository {

    private final AplicativoJpaRepository repository;

    public AplicativoRepositoryImpl(AplicativoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AplicativoModel> buscarTodos() {
        List<Aplicativo> apps = repository.findAll();
        if (apps.size() == 0) {
            return null;
        }
        return repository.findAll().stream().map(app -> Aplicativo.toModel(app)).toList();
    }

    @Override
    public AplicativoModel buscarPorId(Long id) {
        Aplicativo app = repository.findById(id).orElse(null);

        if (app == null) {
            return null;
        }
        return Aplicativo.toModel(app);
    }

    @Override
    public AplicativoModel atualizarCusto(Long id, Double custo) {
        Aplicativo app = repository.findById(id).orElse(null);
        if (app == null) {
            return null;
        }
        app.setCustoMensal(custo);
        repository.save(app);
        return Aplicativo.toModel(app);
    }
}