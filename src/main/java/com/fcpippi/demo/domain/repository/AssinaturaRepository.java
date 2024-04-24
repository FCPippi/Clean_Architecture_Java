package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.infraestructure.entity.Assinatura;

public interface AssinaturaRepository {
    Assinatura criar(Long codigoCliente, Long codigoAplicativo);
    List<Assinatura> buscarPorTipo(String tipo);
    List<Assinatura> buscarPorCliente(Long codigoCliente);
    List<Assinatura> buscarPorAplicativo(Long codigoAplicativo);
    boolean assinaturaValida(Long codigoAssinatura);
}