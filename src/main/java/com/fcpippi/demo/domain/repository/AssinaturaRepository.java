package com.fcpippi.demo.domain.repository;

import java.util.List;

import com.fcpippi.demo.domain.model.AssinaturaModel;

public interface AssinaturaRepository {
    AssinaturaModel criar(long codigoCliente, long codigoAplicativo);

    List<AssinaturaModel> buscarPorTipo(String tipo);

    List<AssinaturaModel> buscarPorCliente(long codigoCliente);

    List<AssinaturaModel> buscarPorAplicativo(long codigoAplicativo);

    AssinaturaModel buscaPorClienteAplicativo(long codigoCliente, long codigoAplicativo);

    AssinaturaModel buscaPorId(long codigoAssinatura);

    boolean assinaturaValida(long codigoAssinatura);
}