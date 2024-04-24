package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.domain.model.AssinaturaModel;


public interface AssinaturaRepository {
    AssinaturaModel criar(Long codigoCliente, Long codigoAplicativo);
    List<AssinaturaModel> buscarPorTipo(String tipo);
    List<AssinaturaModel> buscarPorCliente(Long codigoCliente);
    List<AssinaturaModel> buscarPorAplicativo(Long codigoAplicativo);
    AssinaturaModel buscaPorClienteAplicativo(Long codigoCliente, Long codigoAplicativo);
    AssinaturaModel buscaPorId(Long codigoAssinatura);
    boolean assinaturaValida(Long codigoAssinatura);
}