package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "laudo")
public class Laudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @OneToOne
    @JoinColumn(name = "ordem_servico_id", unique = true, nullable = false)
    private OrdemServico ordemServico;

    public Laudo() {
    }

    public Laudo(String diagnostico, String observacoes, OrdemServico ordemServico) {
        this.diagnostico = diagnostico;
        this.observacoes = observacoes;
        this.ordemServico = ordemServico;
        this.dataEmissao = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public String exibirDetalhes() {
        return String.format(
                "[LAUDO] ID: %d | OS: %d | Diagnóstico: %s | Observações: %s | Data: %s",
                id, ordemServico.getId(), diagnostico, observacoes, dataEmissao);
    }
}