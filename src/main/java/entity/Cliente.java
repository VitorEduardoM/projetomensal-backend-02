package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Automovel> automoveis = new ArrayList<>();

    public void adicionarAutomovel(Automovel automovel) {
        automoveis.add(automovel);
        automovel.setCliente(this);
    }

    public void removerAutomovel(Long idAutomovel) {
        automoveis.removeIf(automovel -> automovel.getId().equals(idAutomovel));
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String exibirDetalhes() {
        return String.format(
                "[CLIENTE] ID: %d | Nome: %s | Telefone: %s | CPF: %s",
                id, nome, telefone, cpf
        );
    }
}