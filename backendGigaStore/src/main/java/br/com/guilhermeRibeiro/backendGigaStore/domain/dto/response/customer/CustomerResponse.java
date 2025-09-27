package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.customer;

public class CustomerResponse {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private boolean active;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String cpf, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.active = active;
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

    public boolean isAtivo() {
        return active;
    }

    public void setAtivo(boolean ativo) {
        this.active = ativo;
    }

    @Override
    public String toString() {
        return "ClienteResponse{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", ativo=" + active +
                '}';
    }
}
