package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.repository.ClienteRepository;
import com.fcpippi.demo.infraestructure.entity.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.buscarTodos();
    }
}
