package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;

import java.math.BigDecimal;

public class DetalheMinResponse {

    private Produto produto;
    private Integer quanatidadeProduto;
    private Double valorProduto;

    public DetalheMinResponse() {
    }

    public DetalheMinResponse(Produto produto, Integer quanatidadeProduto, Double valorProduto) {
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

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }
}
