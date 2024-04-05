package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoMinRequest;

import java.util.List;

public class VendaRequest {

    private Long idCliente;
    private List<ProdutoMinRequest> produtoMinRequest;

    public VendaRequest() {
    }

    public VendaRequest(Long idCliente, List<ProdutoMinRequest> produtoMinRequest) {
        this.idCliente = idCliente;
        this.produtoMinRequest = produtoMinRequest;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ProdutoMinRequest> getProdutoMinRequest() {
        return produtoMinRequest;
    }

    public void setProdutoMinRequest(List<ProdutoMinRequest> produtoMinRequest) {
        this.produtoMinRequest = produtoMinRequest;
    }
}
