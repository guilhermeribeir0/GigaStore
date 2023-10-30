package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.cliente;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.cliente.ClienteResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Cliente;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClienteResponseMapper {

    public abstract ClienteResponse modelToResponse(Cliente cliente);

    public abstract List<ClienteResponse> modelListToResponseList(List<Cliente> clientes);

    @AfterMapping
    private void addMarcaraCpf(@MappingTarget ClienteResponse response) {
        response.setCpf("***" + response.getCpf().substring(3, 9) + "**");
    }
}
