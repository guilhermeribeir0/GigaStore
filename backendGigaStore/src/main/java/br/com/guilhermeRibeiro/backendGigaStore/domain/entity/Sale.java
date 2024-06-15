package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_venda")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer customer;
    private Double value;
    private boolean canceled;

    public Sale() {
    }

    public Sale(LocalDate date, Customer customer, Double value, boolean canceled) {
        this.date = date;
        this.customer = customer;
        this.value = value;
        this.canceled = canceled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getValor() {
        return value;
    }

    public void setValor(Double valor) {
        this.value = valor;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
