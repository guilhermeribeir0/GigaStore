package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.product;

public class ProductResponse {

    private Long id;
    private String name;
    private String reference;
    private Double value;
    private Integer stock;
    private boolean active;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name, String reference, Double value, Integer stock, boolean active) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.value = value;
        this.stock = stock;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProductResponse {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", value=" + value +
                ", stock=" + stock +
                ", active=" + active +
                '}';
    }
}
