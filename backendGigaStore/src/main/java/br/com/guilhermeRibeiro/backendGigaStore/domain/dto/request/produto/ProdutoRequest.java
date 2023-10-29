package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto;

import java.math.BigDecimal;

public class ProdutoRequest {

    private String nome;
    private String referencia;
    private BigDecimal valor;
    private Double estoque;
    private boolean ativo;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, String referencia, BigDecimal valor, Double estoque, boolean ativo) {
        this.nome = nome;
        this.referencia = referencia;
        this.valor = valor;
        this.estoque = estoque;
        this.ativo = ativo;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
