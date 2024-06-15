package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProductRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.produto.ProductResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.produto.ProductResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;
    private final ProductResponseMapper responseMapper;

    public ProductController(
            ProductService productService,
            ProductResponseMapper responseMapper
    ) {
        this.productService = productService;
        this.responseMapper = responseMapper;
    }

    @GetMapping(value = "/findAll")
    public @ResponseBody ResponseEntity<List<ProductResponse>> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        List<ProductResponse> responses = responseMapper.modelListToResponseList(products);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/findProduct/{id}")
    public @ResponseBody ResponseEntity<ProductResponse> findProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        ProductResponse response = responseMapper.modelToResponse(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/registerProduct")
    public @ResponseBody ResponseEntity<ProductResponse> registerProduct(@RequestBody ProductRequest request) {
        Product product = productService.registerProduct(request);
        ProductResponse response = responseMapper.modelToResponse(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProduct/{id}")
    public @ResponseBody ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest request) {
        Product product = productService.updateProduct(id, request);
        ProductResponse response = responseMapper.modelToResponse(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping(value = "/changeActive/{id}")
    public @ResponseBody ResponseEntity<ProductResponse> changeActive(@PathVariable("id") Long id) {
        Product product = productService.changeActive(id);
        ProductResponse response = responseMapper.modelToResponse(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}