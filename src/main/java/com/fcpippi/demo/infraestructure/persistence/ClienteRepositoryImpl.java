package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.model.ClienteModel;
import com.fcpippi.demo.domain.repository.ClienteRepository;
import com.fcpippi.demo.infraestructure.entity.Cliente;
import com.fcpippi.demo.infraestructure.persistence.jpa.ClienteJpaRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class ClienteRepositoryImpl implements ClienteRepository {
    private final ClienteJpaRepository repository;

    public ClienteRepositoryImpl(ClienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClienteModel> buscarTodos() {
        return repository.findAll().stream().map(cliente -> Cliente.toModel(cliente)).toList();
    }

    @Override
    public ClienteModel buscaPorId(long id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            return Cliente.toModel(cliente.get());
        } else {
            return null;
        }

    }
}