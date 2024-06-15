package br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes.DetailMinResponse;

import java.util.List;

public class SaleResponse {

    private Long id;
    private Long idCustomer;
    private List<DetailMinResponse> detailMinResponse;
    private Double value;

    public SaleResponse() {
    }

    public SaleResponse(Long id, Long idCustomer, List<DetailMinResponse> detailMinResponse, Double value) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.detailMinResponse = detailMinResponse;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<DetailMinResponse> getDetalheMinResponse() {
        return detailMinResponse;
    }

    public void setDetalheMinResponse(List<DetailMinResponse> detailMinResponse) {
        this.detailMinResponse = detailMinResponse;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "VendaResponse{" +
                "id=" + id +
                ", idCliente=" + idCustomer +
                ", detalheMinResponse=" + detailMinResponse +
                ", valorTotal=" + value +
                '}';
    }
}
