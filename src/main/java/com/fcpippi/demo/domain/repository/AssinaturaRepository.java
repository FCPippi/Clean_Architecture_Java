package com.fcpippi.demo.domain.repository;

import com.fcpippi.demo.domain.entity.Assinatura;

import java.util.List;

public interface AssinaturaRepository {
    Assinatura criar(Long codigoCliente, Long codigoAplicativo);
    List<Assinatura> buscarPorTipo(String tipo);
    List<Assinatura> buscarPorCliente(Long codigoCliente);
    List<Assinatura> buscarPorAplicativo(Long codigoAplicativo);
    boolean assinaturaValida(Long codigoAssinatura);
}