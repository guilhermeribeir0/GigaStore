package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes.DetalheMinResponse;

import java.util.List;

public class VendaResponse {

    private Long id;
    private Long idCliente;
    private List<DetalheMinResponse> detalheMinResponse;
    private Double valor;

    public VendaResponse() {
    }

    public VendaResponse(Long id, Long idCliente, List<DetalheMinResponse> detalheMinResponse, Double valor) {
        this.id = id;
        this.idCliente = idCliente;
        this.detalheMinResponse = detalheMinResponse;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<DetalheMinResponse> getDetalheMinResponse() {
        return detalheMinResponse;
    }

    public void setDetalheMinResponse(List<DetalheMinResponse> detalheMinResponse) {
        this.detalheMinResponse = detalheMinResponse;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "VendaResponse{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", detalheMinResponse=" + detalheMinResponse +
                ", valorTotal=" + valor +
                '}';
    }
}
