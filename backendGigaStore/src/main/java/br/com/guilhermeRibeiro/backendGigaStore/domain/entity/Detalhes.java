package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import javax.persistence.Column;

public class Detalhes {

    private Venda venda;
    private Produto produto;
    @Column(name = "quantidade_produto")
    private Integer quanatidadeProduto;

    public Detalhes() {
    }

    public Detalhes(Venda venda, Produto produto, Integer quanatidadeProduto) {
        this.venda = venda;
        this.produto = produto;
        this.quanatidadeProduto = quanatidadeProduto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuanatidadeProduto() {
        return quanatidadeProduto;
    }

    public void setQuanatidadeProduto(Integer quanatidadeProduto) {
        this.quanatidadeProduto = quanatidadeProduto;
    }
}
