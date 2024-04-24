package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.model.ClienteModel;
import com.fcpippi.demo.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> buscarTodos() {
        return clienteRepository.buscarTodos();
    }
}
