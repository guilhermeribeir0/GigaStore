package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;
    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @Column(name = "quantity_product")
    private Integer quantityProduct;
    @Column(name = "value_product")
    private Double valueProduct;

    public Detail() {
    }

    public Detail(Sale sale, Product product, Integer quantityProduct, Double valueProduct) {
        this.sale = sale;
        this.product = product;
        this.quantityProduct = quantityProduct;
        this.valueProduct = valueProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
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
