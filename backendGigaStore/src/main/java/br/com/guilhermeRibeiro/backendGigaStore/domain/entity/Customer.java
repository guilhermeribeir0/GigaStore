package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.cliente.CustomerRequest;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CPF
    private String cpf;
    @Email
    private String email;
    private boolean active;

    public Customer() {
    }

    public Customer(CustomerRequest request) {
        this.name = request.getName();
        this.cpf = request.getCpf();
        this.email = request.getEmail();
        this.active = request.isActive();
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

    public void setName(String nome) {
        this.name = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
