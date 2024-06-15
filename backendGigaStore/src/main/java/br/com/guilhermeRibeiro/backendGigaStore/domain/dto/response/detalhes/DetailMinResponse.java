package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;

public class DetailMinResponse {

    private Product product;
    private Integer quantityProduct;
    private Double valueProduct;

    public DetailMinResponse() {
    }

    public DetailMinResponse(Product product, Integer quantityProduct, Double valueProduct) {
        this.product = product;
        this.quantityProduct = quantityProduct;
        this.valueProduct = valueProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Double getValueProduct() {
        return valueProduct;
    }

    public void setValueProduct(Double valueProduct) {
        this.valueProduct = valueProduct;
    }
}
