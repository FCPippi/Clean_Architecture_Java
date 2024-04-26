package com.fcpippi.demo.domain.repository;

public interface PagamentoRepository {
    Object registrar(String dia, String mes, String ano, long codigoAssinatura, double valorPago);
}