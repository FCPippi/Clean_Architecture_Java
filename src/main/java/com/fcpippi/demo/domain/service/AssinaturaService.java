package com.fcpippi.demo.domain.service;

import com.fcpippi.demo.domain.model.AssinaturaModel;
import com.fcpippi.demo.domain.repository.AssinaturaRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssinaturaService {
    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public AssinaturaModel criarAssinatura(Long idCliente, Long idAplicativo) {
        AssinaturaModel assinaturaExistente = assinaturaRepository.buscaPorClienteAplicativo(idCliente, idAplicativo);
        if (assinaturaExistente != null) {
            return null;
        }

        return assinaturaRepository.criar(idCliente, idAplicativo);
    }

    public List<AssinaturaModel> buscarPorTipo(String tipo) {
        return assinaturaRepository.buscarPorTipo(tipo);
    }

    public List<AssinaturaModel> buscarPorCliente(Long codigoCliente) {
        return assinaturaRepository.buscarPorCliente(codigoCliente);
    }

    public List<AssinaturaModel> buscarPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.buscarPorAplicativo(codigoAplicativo);
    }

    public boolean assinaturaValida(Long codigoAssinatura) {
        return assinaturaRepository.assinaturaValida(codigoAssinatura);
    }
}
