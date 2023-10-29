package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private String referencia;
    private BigDecimal valor;
    private Double estoque;
    private boolean ativo;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String nome, String referencia, BigDecimal valor, Double estoque, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.referencia = referencia;
        this.valor = valor;
        this.estoque = estoque;
        this.ativo = ativo;
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

    @Override
    public String toString() {
        return "ProdutoResponse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", referencia='" + referencia + '\'' +
                ", valor=" + valor +
                ", estoque=" + estoque +
                ", ativo=" + ativo +
                '}';
    }
}
