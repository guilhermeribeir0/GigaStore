package br.com.guilhermeRibeiro.backendGigaStore.domain.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super(createdMessage(id));
    }

    private static String createdMessage(Long id) {
        return String.format("Product not found \nId: %d", id);
    }
}
