package com.fcpippi.demo.application.useCases;

import java.util.List;

import com.fcpippi.demo.application.dto.ClienteDTO;
import com.fcpippi.demo.domain.service.ClienteService;

public class ListaClientesUC {
    private ClienteService clienteService;

    public ListaClientesUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDTO> run() {
        return this.clienteService.buscarTodos().stream().map(cliente -> ClienteDTO.fromModel(cliente)).toList();
    }
}
