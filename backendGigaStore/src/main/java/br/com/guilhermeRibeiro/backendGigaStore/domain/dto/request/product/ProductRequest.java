package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.product;

public class ProductRequest {

    private String name;
    private String reference;
    private Double value;
    private Integer stock;
    private boolean active;

    public ProductRequest() {
    }

    public ProductRequest(String name, String reference, Double value, Integer stock, boolean active) {
        this.name = name;
        this.reference = reference;
        this.value = value;
        this.stock = stock;
        this.active = active;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getReferencia() {
        return reference;
    }

    public void setReferencia(String referencia) {
        this.reference = referencia;
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
}
