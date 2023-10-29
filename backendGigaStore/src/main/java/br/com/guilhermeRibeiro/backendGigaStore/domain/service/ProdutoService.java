package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.produto.ProdutoResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.produto.ProdutoResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoResponseMapper responseMapper;

    public ProdutoResponse cadastrarProduto(ProdutoRequest request) {
        try {
            Produto produto = new Produto(request);
            produtoRepository.save(produto);
            return responseMapper.modelToResponse(produto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar Produto." + e.getMessage());
        }
    }
}
