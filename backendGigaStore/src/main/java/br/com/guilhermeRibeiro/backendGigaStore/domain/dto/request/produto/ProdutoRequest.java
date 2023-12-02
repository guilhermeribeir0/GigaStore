package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto;

public class ProdutoRequest {

    private String nome;
    private String referencia;
    private Double valor;
    private Integer estoque;
    private boolean ativo;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, String referencia, Double valor, Integer estoque, boolean ativo) {
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
