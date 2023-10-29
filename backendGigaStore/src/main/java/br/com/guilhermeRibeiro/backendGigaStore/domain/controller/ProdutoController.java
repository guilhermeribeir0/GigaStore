package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.produto.ProdutoResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public @ResponseBody ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest request) {
        ProdutoResponse response = produtoService.cadastrarProduto(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
