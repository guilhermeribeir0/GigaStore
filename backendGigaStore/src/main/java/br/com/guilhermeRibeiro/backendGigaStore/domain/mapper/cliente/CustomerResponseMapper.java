package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.cliente;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.customer.CustomerResponse;

@Mapper(componentModel = "spring")
public abstract class CustomerResponseMapper {

    public abstract CustomerResponse modelToResponse(Customer customer);

    public abstract List<CustomerResponse> modelListToResponseList(List<Customer> customers);

    @AfterMapping
    protected void addMascaraCpf(@MappingTarget CustomerResponse response) {
        response.setCpf("***" + response.getCpf().substring(3, 9) + "**");
    }
}
