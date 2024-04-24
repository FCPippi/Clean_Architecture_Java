package com.fcpippi.demo.domain.repository;

public interface PagamentoRepository {
    Object registrar(String dia, String mes, String ano, Long codigoAssinatura, Double valorPago);
}