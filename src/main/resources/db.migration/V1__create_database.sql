CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(20),
    cpf VARCHAR(14)
);

CREATE TABLE automovel (
    id BIGSERIAL PRIMARY KEY,
    modelo VARCHAR(255),
    placa VARCHAR(10),
    ano_fabricacao INTEGER,
    cliente_id BIGINT,
    CONSTRAINT fk_automovel_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    preco DOUBLE PRECISION,
    quantidade_estoque INTEGER,
    categoria VARCHAR(255),
    marca VARCHAR(255)
);

CREATE TABLE servico (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    preco DOUBLE PRECISION,
    duracao_minutos INTEGER,
    tipo VARCHAR(255)
);

CREATE TABLE ordem_servico (
    id BIGSERIAL PRIMARY KEY,
    data_abertura DATE,
    data_finalizacao DATE,
    status VARCHAR(50),
    cliente_id BIGINT NOT NULL,
    automovel_id BIGINT NOT NULL,
    CONSTRAINT fk_os_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_os_automovel FOREIGN KEY (automovel_id) REFERENCES automovel(id)
);

CREATE TABLE ordem_servico_servico (
    ordem_servico_id BIGINT NOT NULL,
    servico_id BIGINT NOT NULL,
    PRIMARY KEY (ordem_servico_id, servico_id),
    CONSTRAINT fk_oss_ordem FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id),
    CONSTRAINT fk_oss_servico FOREIGN KEY (servico_id) REFERENCES servico(id)
);

CREATE TABLE ordem_servico_produto (
    ordem_servico_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    PRIMARY KEY (ordem_servico_id, produto_id),
    CONSTRAINT fk_osp_ordem FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id),
    CONSTRAINT fk_osp_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);