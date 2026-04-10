package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "data_finalizacao")
    private LocalDate dataFinalizacao;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "automovel_id", nullable = false)
    private Automovel automovel;

    @ManyToMany
    @JoinTable(
            name = "ordem_servico_servico",
            joinColumns = @JoinColumn(name = "ordem_servico_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<Servico> servicos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "ordem_servico_produto",
            joinColumns = @JoinColumn(name = "ordem_servico_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();

    public OrdemServico() {
    }

    public OrdemServico(Cliente cliente, Automovel automovel) {
        this.cliente = cliente;
        this.automovel = automovel;
        this.dataAbertura = LocalDate.now();
        this.status = "ABERTA";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void finalizarOrdem() {
        this.status = "FINALIZADA";
        this.dataFinalizacao = LocalDate.now();
    }

    public String getStatus() {
        return status;
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double calcularValorTotal() {
        double total = 0;

        for (Servico s : servicos) {
            total += s.getPreco();
        }

        for (Produto p : produtos) {
            total += p.getPreco();
        }

        return total;
    }

    public String exibirDetalhes() {
        return String.format(
                "[ORDEM] ID: %d | Cliente: %s | Veículo: %s | Status: %s | Total: R$ %.2f",
                id,
                cliente.getNome(),
                automovel.getModelo(),
                status,
                calcularValorTotal()
        );
    }
}