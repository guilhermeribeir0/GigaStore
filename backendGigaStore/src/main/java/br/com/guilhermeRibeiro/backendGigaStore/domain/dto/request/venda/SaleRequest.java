package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProductMinRequest;

import java.util.List;

public class SaleRequest {

    private Long idCustomer;
    private List<ProductMinRequest> productMinRequest;

    public SaleRequest() {
    }

    public SaleRequest(Long idCustomer, List<ProductMinRequest> productMinRequest) {
        this.idCustomer = idCustomer;
        this.productMinRequest = productMinRequest;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<ProductMinRequest> getProdutoMinRequest() {
        return productMinRequest;
    }

    public void setProdutoMinRequest(List<ProductMinRequest> productMinRequest) {
        this.productMinRequest = productMinRequest;
    }
}
