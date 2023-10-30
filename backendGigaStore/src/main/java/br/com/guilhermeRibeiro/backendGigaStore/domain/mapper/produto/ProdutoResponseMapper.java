package br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.produto;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.produto.ProdutoResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoResponseMapper {

    ProdutoResponse modelToResponse(Produto produto);

    List<ProdutoResponse> modelListToResponseList(List<Produto> produtos);

}
