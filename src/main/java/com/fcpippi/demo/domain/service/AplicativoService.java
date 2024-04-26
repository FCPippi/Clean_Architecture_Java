package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.model.AplicativoModel;
import com.fcpippi.demo.domain.repository.AplicativoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {
    private final AplicativoRepository aplicativoRepository;

    public AplicativoService(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<AplicativoModel> buscarTodos() {
        return aplicativoRepository.buscarTodos();
    }

    public AplicativoModel atualizarCusto(long codigoAplicativo, double custo) {
        return aplicativoRepository.atualizarCusto(codigoAplicativo, custo);
    }
}