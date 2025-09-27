package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.sale.SaleRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.sale.SaleResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Sale;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.venda.SaleResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class SaleController {

    private final SaleService saleService;
    private final SaleResponseMapper responseMapper;

    public SaleController(
            SaleService saleService,
            SaleResponseMapper responseMapper
    ) {
        this.saleService = saleService;
        this.responseMapper = responseMapper;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<SaleResponse>> findAllSales() {
        List<Sale> sales = saleService.findAllSales();
        List<SaleResponse> responses = responseMapper.modelToList(sales);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<SaleResponse> registerSale(@RequestBody SaleRequest request) {
        Sale sale = saleService.registerSale(request);
        SaleResponse response = responseMapper.modelToResponse(sale);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
