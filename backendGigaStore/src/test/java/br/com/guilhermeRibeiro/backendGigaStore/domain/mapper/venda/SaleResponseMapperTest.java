package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.venda;

import java.util.List;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Sale;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.DetailService;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.sale.SaleResponse;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SaleResponseMapperTest {

    @Autowired
    private SaleResponseMapper responseMapper;

    @MockBean
    private DetailService detailService;

    @Test
    void testModelToResponse() {
        Customer customer = new Customer();
        customer.setId(1L);

        Sale sale = new Sale();
        sale.setId(1L);
        sale.setCustomer(customer);

        when(detailService.findDetailsBySaleId(1L)).thenReturn(Collections.emptyList());

        SaleResponse saleResponse = responseMapper.modelToResponse(sale);

        assertEquals(sale.getId(), saleResponse.getId());
        assertEquals(sale.getCustomer().getId(), saleResponse.getIdCustomer());
    }

    @Test
    void testModelToList() {
        Customer customer = new Customer();
        customer.setId(1L);

        Sale sale = new Sale();
        sale.setId(1L);
        sale.setCustomer(customer);

        List<Sale> saleList = Collections.singletonList(sale);

        when(detailService.findDetailsBySaleId(1L)).thenReturn(Collections.emptyList());

        List<SaleResponse> saleResponseList = responseMapper.modelToList(saleList);

        assertEquals(saleList.size(), saleResponseList.size());
        assertEquals(saleList.get(0).getId(), saleResponseList.get(0).getId());
        assertEquals(saleList.get(0).getCustomer().getId(), saleResponseList.get(0).getIdCustomer());
    }

}

