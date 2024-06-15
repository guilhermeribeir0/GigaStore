package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto;

public class ProductMinRequest {

    private Long id;
    private Integer quantity;

    public ProductMinRequest() {
    }

    public ProductMinRequest(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
