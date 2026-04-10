INSERT INTO cliente (nome, telefone, cpf) VALUES ('João Silva', '11999999999', '123.456.789-00');
INSERT INTO cliente (nome, telefone, cpf) VALUES ('Maria Santos', '11888888888', '987.654.321-00');

SELECT * FROM cliente;
SELECT * FROM cliente WHERE nome LIKE '%Silva%';

UPDATE cliente SET telefone = '11777777777' WHERE id = 1;

DELETE FROM cliente WHERE id = 2;

INSERT INTO automovel (modelo, placa, ano_fabricacao, cliente_id) VALUES ('Civic', 'ABC1234', 2020, 1);
INSERT INTO automovel (modelo, placa, ano_fabricacao) VALUES ('Corolla', 'XYZ5678', 2022);

SELECT * FROM automovel;
SELECT * FROM automovel WHERE cliente_id IS NULL;

UPDATE automovel SET modelo = 'Civic Touring' WHERE id = 1;

DELETE FROM automovel WHERE id = 2;

INSERT INTO produto (nome, preco, quantidade_estoque, categoria, marca) VALUES ('205/55R16', 450.00, 10, 'Pneu de carro', 'Pirelli');
INSERT INTO produto (nome, preco, quantidade_estoque, categoria, marca) VALUES ('Limpa Radiador', 25.90, 50, 'Químicos', '');

SELECT * FROM produto;
SELECT * FROM produto WHERE categoria = 'Pneu de carro';

UPDATE produto SET quantidade_estoque = 8 WHERE id = 1;

DELETE FROM produto WHERE id = 2;

INSERT INTO servico (nome, preco, duracao_minutos, tipo) VALUES ('Troca de Oleo', 80.00, 30, 'Troca');
INSERT INTO servico (nome, preco, duracao_minutos, tipo) VALUES ('Alinhamento', 120.00, 45, 'Alinhamento');

SELECT * FROM servico;
SELECT * FROM servico WHERE tipo = 'Troca';

UPDATE servico SET preco = 90.00 WHERE id = 1;

DELETE FROM servico WHERE id = 2;

INSERT INTO ordem_servico (data_abertura, status, cliente_id, automovel_id) VALUES (CURRENT_DATE, 'ABERTA', 1, 1);

SELECT * FROM ordem_servico;

UPDATE ordem_servico SET status = 'FINALIZADA', data_finalizacao = CURRENT_DATE WHERE id = 1;

DELETE FROM ordem_servico WHERE id = 1;

INSERT INTO ordem_servico_servico (ordem_servico_id, servico_id) VALUES (1, 1);

SELECT * FROM ordem_servico_servico;

DELETE FROM ordem_servico_servico WHERE ordem_servico_id = 1 AND servico_id = 1;

INSERT INTO ordem_servico_produto (ordem_servico_id, produto_id) VALUES (1, 1);

SELECT * FROM ordem_servico_produto;

DELETE FROM ordem_servico_produto WHERE ordem_servico_id = 1 AND produto_id = 1;

INSERT INTO laudo (diagnostico, observacoes, data_emissao, ordem_servico_id) VALUES ('Desgaste nos freios', 'Recomendada troca em 30 dias', CURRENT_DATE, 1);

SELECT * FROM laudo;

UPDATE laudo SET observacoes = 'Troca realizada' WHERE id = 1;

DELETE FROM laudo WHERE id = 1;

SELECT os.id, c.nome, a.modelo, os.status
FROM ordem_servico os
INNER JOIN cliente c ON os.cliente_id = c.id
INNER JOIN automovel a ON os.automovel_id = a.id;

SELECT c.nome, a.modelo
FROM cliente c
LEFT JOIN automovel a ON a.cliente_id = c.id;

SELECT a.modelo, c.nome
FROM automovel a
RIGHT JOIN cliente c ON a.cliente_id = c.id;

SELECT os.id, s.nome, s.preco
FROM ordem_servico os
INNER JOIN ordem_servico_servico oss ON os.id = oss.ordem_servico_id
INNER JOIN servico s ON oss.servico_id = s.id;

SELECT os.id, p.nome, p.preco
FROM ordem_servico os
INNER JOIN ordem_servico_produto osp ON os.id = osp.ordem_servico_id
INNER JOIN produto p ON osp.produto_id = p.id;

SELECT c.nome, COUNT(a.id) AS total_automoveis
FROM cliente c
LEFT JOIN automovel a ON a.cliente_id = c.id
GROUP BY c.id, c.nome;