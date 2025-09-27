package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.produto;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.product.ProductResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    ProductResponse modelToResponse(Product product);

    List<ProductResponse> modelListToResponseList(List<Product> products);

}
