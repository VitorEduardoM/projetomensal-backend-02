package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "servico")
public class Servico extends Item {

    @Column(name = "duracao_minutos")
    private int duracaoMinutos;

    @Column(name = "tipo")
    private String tipo;

    public Servico() {
    }

    public Servico(Long id, String nome, double preco, int duracaoMinutos, String tipo) {
        super(id, nome, preco);
        this.duracaoMinutos = duracaoMinutos;
        this.tipo = tipo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String exibirDetalhes() {
        return String.format(
                "[SERVIÇO] ID: %d | Nome: %s | Tipo: %s | Preço: R$ %.2f | Duração: %d min",
                getId(), getNome(), tipo, getPreco(), duracaoMinutos
        );
    }
}