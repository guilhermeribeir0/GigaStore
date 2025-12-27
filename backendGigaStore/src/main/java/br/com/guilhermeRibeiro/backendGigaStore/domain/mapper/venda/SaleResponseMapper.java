package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.venda;

import java.util.List;
import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeforeMapping;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Sale;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detail;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.DetailService;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.sale.SaleResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.details.DetailMinResponse;

@Mapper(componentModel = "spring")
public abstract class SaleResponseMapper {

    @Autowired
    private DetailService detailService;

    @Mapping(target = "idCustomer", source = "sale.customer.id")
    public abstract SaleResponse modelToResponse(Sale sale);

    public abstract List<SaleResponse> modelToList(List<Sale> sale);

    @BeforeMapping
    protected void mapperDetails(Sale sale, @MappingTarget SaleResponse response) {
        List<DetailMinResponse> responses = new ArrayList<>();
        List<Detail> details = detailService.findDetailsBySaleId(sale.getId());

        for (Detail detail : details) {
            DetailMinResponse detailMinResponse = new DetailMinResponse();
            detailMinResponse.setProduct(detail.getProduct());
            detailMinResponse.setQuantityProduct(detail.getQuantityProduct());
            detailMinResponse.setValueProduct(detail.getValueProduct());
            responses.add(detailMinResponse);
        }

        response.setDetailsMinResponse(responses);
    }
}
