package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProductRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.ProductNotFoundException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findProductById(Long id) {
        Optional<Product> produto = productRepository.findById(id);
        if (produto.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        return produto.get();
    }

    @Transactional
    public Product registerProduct(ProductRequest request) {
        try {
            Product product = new Product(request);
            return productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error registering product." + e.getMessage());
        }
    }

    public Product updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .map(prod -> {
                    prod.setNome(request.getNome());
                    prod.setReference(request.getReferencia());
                    prod.setValue(request.getValue());
                    return productRepository.save(prod);
                }).orElseThrow(() -> new ProductNotFoundException(id));

        return product;
    }

    public Product inputStock(Long id, Integer quantidade) {
        Product product = productRepository.findById(id)
                .map(prod -> {
                    prod.setStock(prod.getStock() + quantidade);
                    return productRepository.save(prod);
                }).orElseThrow(() -> new ProductNotFoundException(id));

        return product;
    }

    public Product exitStock(Long id, Integer quantidade) {
        Product product = productRepository.findById(id)
                .map(prod -> {
                    prod.setStock(prod.getStock() - quantidade);
                    return productRepository.save(prod);
                }).orElseThrow(() -> new ProductNotFoundException(id));

        return product;
    }

    @Transactional
    public Product changeActive(Long id) {
        Product product = (productRepository.findById(id)
                .map(prod -> {
                    prod.setActive(!prod.isActive());
                    return productRepository.save(prod);
                }).orElseThrow(() -> new ProductNotFoundException(id)));

        return product;
    }
}
