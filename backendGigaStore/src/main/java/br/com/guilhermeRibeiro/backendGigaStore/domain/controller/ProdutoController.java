package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.produto.ProdutoResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.produto.ProdutoResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoResponseMapper responseMapper;

    @GetMapping
    public @ResponseBody ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        List<ProdutoResponse> responses = responseMapper.modelListToResponseList(produtos);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> buscaProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        ProdutoResponse response = responseMapper.modelToResponse(produto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest request) {
        Produto produto = produtoService.cadastrarProduto(request);
        ProdutoResponse response = responseMapper.modelToResponse(produto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
