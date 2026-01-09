package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.cliente;

import java.util.List;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.customer.CustomerResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerResponseMapperTest {

    @Autowired
    private CustomerResponseMapper responseMapper;

    @Test
    void testModelToResponse() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCpf("11122233344");

        CustomerResponse customerResponse = responseMapper.modelToResponse(customer);

        assertEquals(customer.getId(), customerResponse.getId());
        assertEquals("***222333**", customerResponse.getCpf());
    }

    @Test
    void testModelToList() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCpf("11122233344");

        List<Customer> customerList = Collections.singletonList(customer);

        List<CustomerResponse> customerResponseList = responseMapper.modelListToResponseList(customerList);

        assertEquals(customerList.size(), customerResponseList.size());
        assertEquals(customerList.get(0).getId(), customerResponseList.get(0).getId());
        assertEquals("***222333**", customerResponseList.get(0).getCpf());
    }

}
