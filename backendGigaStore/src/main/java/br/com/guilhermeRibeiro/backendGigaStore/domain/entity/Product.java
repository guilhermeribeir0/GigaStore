package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.product.ProductRequest;

import javax.persistence.*;

@Entity
@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String reference;
    private Double value;
    private Integer stock;
    private boolean active;

    public Product() {
    }

    public Product(ProductRequest request) {
        this.name = request.getNome();
        this.reference = request.getReferencia();
        this.value = request.getValue();
        this.stock = request.getStock();
        this.active = request.isActive();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
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
}
