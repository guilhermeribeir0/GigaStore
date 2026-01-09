package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.produto;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.product.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    ProductResponse modelToResponse(Product product);

    List<ProductResponse> modelListToResponseList(List<Product> products);

}
