package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.entity.Cliente;
import com.fcpippi.demo.domain.repository.ClienteRepository;
import com.fcpippi.demo.infraestructure.persistence.jpa.ClienteJpaRepository;

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