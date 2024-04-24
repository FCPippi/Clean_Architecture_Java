package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.repository.AplicativoRepository;
import com.fcpippi.demo.infraestructure.entity.Aplicativo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {
    private final AplicativoRepository aplicativoRepository;

    public AplicativoService(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<Aplicativo> buscarTodos() {
        return aplicativoRepository.buscarTodos();
    }

    public Aplicativo atualizarCusto(Long idAplicativo, Double custo) {
        aplicativoRepository.atualizarCusto(idAplicativo, custo);
        return aplicativoRepository.buscarPorId(idAplicativo);
    }
}