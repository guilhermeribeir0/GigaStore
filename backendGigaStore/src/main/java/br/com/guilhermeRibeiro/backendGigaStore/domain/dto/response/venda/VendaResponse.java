package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes.DetalheMinResponse;

import java.math.BigDecimal;

public class VendaResponse {

    private Long id;
    private Long idCliente;
    private DetalheMinResponse detalheMinResponse;
    private BigDecimal valorTotal;

    public VendaResponse() {
    }

    public VendaResponse(Long id, Long idCliente, DetalheMinResponse detalheMinResponse, BigDecimal valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.detalheMinResponse = detalheMinResponse;
        this.valorTotal = valorTotal;
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

    public DetalheMinResponse getDetalheMinResponse() {
        return detalheMinResponse;
    }

    public void setDetalheMinResponse(DetalheMinResponse detalheMinResponse) {
        this.detalheMinResponse = detalheMinResponse;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "VendaResponse{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", detalheMinResponse=" + detalheMinResponse +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
