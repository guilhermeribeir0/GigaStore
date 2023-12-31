package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoRequest;

import javax.persistence.*;

@Entity
@Table(name = "t_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String referencia;
    private Double valor;
    private Integer estoque;
    private boolean ativo;

    public Produto() {
    }

    public Produto(ProdutoRequest request) {
        this.nome = request.getNome();
        this.referencia = request.getReferencia();
        this.valor = request.getValor();
        this.estoque = request.getEstoque();
        this.ativo = request.isAtivo();
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
