INSERT INTO aplicativo (nome, custo_mensal) VALUES
    ('Aplicativo 1', 19.99),
    ('Aplicativo 2', 29.99),
    ('Aplicativo 3', 39.99),
    ('Aplicativo 4', 49.99),
    ('Aplicativo 5', 59.99);

INSERT INTO cliente (nome, email) VALUES
    ('Cliente 1', 'cliente1@example.com'),
    ('Cliente 2', 'cliente2@example.com'),
    ('Cliente 3', 'cliente3@example.com'),
    ('Cliente 4', 'cliente4@example.com'),
    ('Cliente 5', 'cliente5@example.com'),
    ('Cliente 6', 'cliente6@example.com'),
    ('Cliente 7', 'cliente7@example.com'),
    ('Cliente 8', 'cliente8@example.com'),
    ('Cliente 9', 'cliente9@example.com'),
    ('Cliente 10', 'cliente10@example.com');

INSERT INTO assinatura (aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES
    (1, 1, '2023-01-01', '2023-12-31'),
    (2, 2, '2023-02-01', '2024-01-31'),
    (3, 3, '2023-03-01', '2024-02-29'),
    (4, 4, '2023-04-01', '2024-03-31'),
    (5, 5, '2023-05-01', '2024-04-30');

INSERT INTO usuario (usuario, senha) VALUES
    ('admin', 'senha123');
