package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.cliente;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.cliente.CustomerResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CustomerResponseMapper {

    public abstract CustomerResponse modelToResponse(Customer customer);

    public abstract List<CustomerResponse> modelListToResponseList(List<Customer> customers);

    @AfterMapping
    private void addMarcaraCpf(@MappingTarget CustomerResponse response) {
        response.setCpf("***" + response.getCpf().substring(3, 9) + "**");
    }
}
