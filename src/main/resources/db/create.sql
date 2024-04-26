DROP TABLE IF EXISTS pagamento;
DROP TABLE IF EXISTS assinatura;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS aplicativo;
DROP TABLE IF EXISTS usuario;

CREATE TABLE aplicativo (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    custo_mensal DECIMAL(10, 2) NOT NULL
);

CREATE TABLE cliente (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE assinatura (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    aplicativo_codigo BIGINT NOT NULL,
    cliente_codigo BIGINT NOT NULL,
    inicio_vigencia DATE NOT NULL,
    fim_vigencia DATE NOT NULL,
    FOREIGN KEY (aplicativo_codigo) REFERENCES aplicativo(codigo),
    FOREIGN KEY (cliente_codigo) REFERENCES cliente(codigo)
);

CREATE TABLE pagamento (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    assinatura_codigo BIGINT NOT NULL,
    valor_pago DECIMAL(10, 2) NOT NULL,
    data_pagamento DATE NOT NULL,
    promocao VARCHAR(100),
    FOREIGN KEY (assinatura_codigo) REFERENCES assinatura(codigo)
);

CREATE TABLE usuario (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);