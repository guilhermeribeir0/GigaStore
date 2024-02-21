package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.cliente.ClienteResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.detalhes.DetalheMinResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.venda.VendaResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detalhes;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.DetalhesService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VendaResponseMapper {

    @Autowired
    private DetalhesService detalhesService;

    @Mapping(target = "idCliente", source = "venda.cliente.id")
    public abstract VendaResponse modelToResponse(Venda venda);

    public abstract List<VendaResponse> modelToList(List<Venda> venda);

    @BeforeMapping
    protected void mapearDetalhes(Venda venda, @MappingTarget VendaResponse response) {
        DetalheMinResponse detalheMinResponse = new DetalheMinResponse();
        List<DetalheMinResponse> responses = new ArrayList<>();
        List<Detalhes> listaDetalhes = detalhesService.buscarDetalhesPorIdVenda(venda.getId());

        for (Detalhes detalhes: listaDetalhes) {
            detalheMinResponse.setProduto(detalhes.getProduto());
            detalheMinResponse.setQuanatidadeProduto(detalhes.getQuanatidadeProduto());
            detalheMinResponse.setValorProduto(detalhes.getValorProduto());
            responses.add(detalheMinResponse);
        }

        response.setDetalheMinResponse(responses);
    }
}
