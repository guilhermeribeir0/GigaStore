package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;

import java.math.BigDecimal;

public class DetalheMinResponse {

    private Produto produto;
    private Integer quanatidadeProduto;
    private BigDecimal valorProduto;

    public DetalheMinResponse() {
    }

    public DetalheMinResponse(Produto produto, Integer quanatidadeProduto, BigDecimal valorProduto) {
        this.produto = produto;
        this.quanatidadeProduto = quanatidadeProduto;
        this.valorProduto = valorProduto;
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

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }
}
