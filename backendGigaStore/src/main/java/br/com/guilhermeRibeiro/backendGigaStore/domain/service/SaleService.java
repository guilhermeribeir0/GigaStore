package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProductMinRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.venda.SaleRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detail;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Product;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Sale;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.ProductInsufficientStockException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.SaleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final DetailService detailService;

    public SaleService(
            SaleRepository saleRepository,
            CustomerService customerService,
            ProductService productService,
            DetailService detailService
    ) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.detailService = detailService;
    }

    public List<Sale> findAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales;
    }

    @Transactional(rollbackOn = Exception.class)
    public Sale registerSale(SaleRequest request) {
        Customer customer = customerService.findClientById(request.getIdCustomer());

        Double totalVenda = setTotalAmountSale(request.getProdutoMinRequest());

        Sale sale = new Sale(LocalDate.now(), customer, totalVenda, false);
        Sale saleSaved = saleRepository.save(sale);

        registerDetailsSale(saleSaved, request.getProdutoMinRequest());

        return saleSaved;
    }

    private void registerDetailsSale(Sale sale, List<ProductMinRequest> requests) {
        try {
            List<Detail> detailList = new ArrayList<>();
            List<Product> products = setProductsSale(requests);

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == requests.get(i).getId()) {
                    Detail detail = new Detail(sale, products.get(i), requests.get(i).getQuantity(), products.get(i).getValue());
                    detailList.add(detailService.registerDetails(detail));
                    productService.exitStock(products.get(i).getId(), requests.get(i).getQuantity());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error when registering sale details. " + e.getMessage());
        }
    }

    private Double setTotalAmountSale(List<ProductMinRequest> produtos) {
        double total = 0.0;
        for (ProductMinRequest produto: produtos) {
            double valorProduto = productService.findProductById(produto.getId()).getValue();
            total += (valorProduto * produto.getQuantity());
        }
        return total;
    }

    private List<Product> setProductsSale(List<ProductMinRequest> requests) {
        try {
            List<Product> products = new ArrayList<>();
            List<Product> productsOutOfStock = new ArrayList<>();

            for (ProductMinRequest request: requests) {
                Product product = productService.findProductById(request.getId());
                if (validateStockProducts(product, request.getQuantity())) {
                    products.add(product);
                } else {
                    productsOutOfStock.add(product);
                }
            }

            if (!validateProductsSale(products, requests)) {
                throw new ProductInsufficientStockException(productsOutOfStock);
            }

            return products;
        } catch (Exception e) {
            throw new RuntimeException("Error defining sale products. " + e.getMessage());
        }
    }

    private boolean validateProductsSale(List<Product> products, List<ProductMinRequest> requests) {
        return products.size() == requests.size();
    }

    private boolean validateStockProducts(Product product, Integer quantidade) {
        return product.getStock() >= quantidade;
    }
}
