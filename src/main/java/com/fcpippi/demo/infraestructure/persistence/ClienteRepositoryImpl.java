package com.fcpippi.demo.infrastructure.persistence;

import com.fcpippi.demo.domain.entity.Cliente;
import com.fcpippi.demo.domain.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    private final ClienteJpaRepository clienteRepositoryJPA;

    public ClienteRepositoryImpl(ClienteJpaRepository clienteRepositoryJPA) {
        this.clienteRepositoryJPA = clienteRepositoryJPA;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepositoryJPA.findAll();
    }
}