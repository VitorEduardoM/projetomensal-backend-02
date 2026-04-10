CREATE TABLE laudo (
    id BIGSERIAL PRIMARY KEY,
    diagnostico VARCHAR(500),
    observacoes VARCHAR(500),
    data_emissao DATE,
    ordem_servico_id BIGINT NOT NULL UNIQUE,
    CONSTRAINT fk_laudo_ordem_servico FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id)
);

CREATE OR REPLACE FUNCTION fn_atualizar_status_os()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.data_finalizacao IS NOT NULL AND OLD.data_finalizacao IS NULL THEN
        NEW.status := 'FINALIZADA';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_atualizar_status_os
BEFORE UPDATE ON ordem_servico
FOR EACH ROW
EXECUTE FUNCTION fn_atualizar_status_os();

CREATE OR REPLACE FUNCTION fn_uppercase_placa()
RETURNS TRIGGER AS $$
BEGIN
    NEW.placa := UPPER(NEW.placa);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_uppercase_placa
BEFORE INSERT OR UPDATE ON automovel
FOR EACH ROW
EXECUTE FUNCTION fn_uppercase_placa();

CREATE OR REPLACE FUNCTION fn_impedir_exclusao_cliente()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM ordem_servico WHERE cliente_id = OLD.id AND status = 'ABERTA') THEN
        RAISE EXCEPTION 'Nao e possivel excluir cliente com Ordem de Servico em aberto';
    END IF;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_impedir_exclusao_cliente_com_os
BEFORE DELETE ON cliente
FOR EACH ROW
EXECUTE FUNCTION fn_impedir_exclusao_cliente();