package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto;

public class ProdutoMinRequest {

    private Long id;
    private Integer quantidade;

    public ProdutoMinRequest() {
    }

    public ProdutoMinRequest(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
