package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.repository.AssinaturaRepository;
import com.fcpippi.demo.infraestructure.entity.Assinatura;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssinaturaService {
    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public Assinatura criar(Long codigoCliente, Long codigoAplicativo) {
        return assinaturaRepository.criar(codigoCliente, codigoAplicativo);
    }

    public List<Assinatura> buscarPorTipo(String tipo) {
        return assinaturaRepository.buscarPorTipo(tipo);
    }

    public List<Assinatura> buscarPorCliente(Long codigoCliente) {
        return assinaturaRepository.buscarPorCliente(codigoCliente);
    }

    public List<Assinatura> buscarPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.buscarPorAplicativo(codigoAplicativo);
    }

    public boolean assinaturaValida(Long codigoAssinatura) {
        return assinaturaRepository.assinaturaValida(codigoAssinatura);
    }
}
