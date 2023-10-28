package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    private Cliente cliente;
    @OneToMany
    private Detalhes detalhes;
    private BigDecimal valor;
    private boolean cancelada;

    public Venda() {
    }

    public Venda(Long id, LocalDate dataCadastro, Cliente cliente, Detalhes detalhes, BigDecimal valor, boolean cancelada) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.cliente = cliente;
        this.detalhes = detalhes;
        this.valor = valor;
        this.cancelada = cancelada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Detalhes getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(Detalhes detalhes) {
        this.detalhes = detalhes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
}
