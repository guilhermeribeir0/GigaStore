package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.cliente;

public class ClienteRequest {

    private String nome;
    private String cpf;
    private String email;
    private boolean ativo;

    public ClienteRequest() {
    }

    public ClienteRequest(String nome, String cpf, String email, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
