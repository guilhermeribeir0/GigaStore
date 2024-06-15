package br.com.guilhermeRibeiro.backendGigaStore.domain.exception;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;

import java.util.List;

public class ProductInsufficientStockException extends RuntimeException {

    public ProductInsufficientStockException(List<Product> products) {
        super(createdMessage(products));
    }

    private static String createdMessage(List<Product> products) {
        return String.format("Product(s) with insufficient stock to complete the sale \n %s", products);
    }
}
