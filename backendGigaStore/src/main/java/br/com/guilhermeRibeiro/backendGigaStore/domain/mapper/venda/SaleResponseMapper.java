package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.venda;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.details.DetailMinResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.sale.SaleResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detail;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Sale;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.DetailService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SaleResponseMapper {

    @Autowired
    private DetailService detailService;

    @Mapping(target = "idCustomer", source = "sale.customer.id")
    public abstract SaleResponse modelToResponse(Sale sale);

    public abstract List<SaleResponse> modelToList(List<Sale> sale);

    @BeforeMapping
    protected void mapperDetails(Sale sale, @MappingTarget SaleResponse response) {
        DetailMinResponse detailMinResponse = new DetailMinResponse();
        List<DetailMinResponse> responses = new ArrayList<>();
        List<Detail> details = detailService.findDetailsBySaleId(sale.getId());

        for (Detail detail : details) {
            detailMinResponse.setProduct(detail.getProduct());
            detailMinResponse.setQuantityProduct(detail.getQuantityProduct());
            detailMinResponse.setValueProduct(detail.getValueProduct());
            responses.add(detailMinResponse);
        }

        response.setDetailMinResponse(responses);
    }
}
