package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.venda.VendaRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.venda.VendaResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.venda.VendaResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private VendaResponseMapper responseMapper;

    @GetMapping
    public @ResponseBody ResponseEntity<List<VendaResponse>> listaVendas() {
        List<Venda> vendas = vendaService.listarVendas();
        List<VendaResponse> responses = responseMapper.modelToList(vendas);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<VendaResponse> cadastrar(@RequestBody VendaRequest request) {
        Venda venda = vendaService.cadastrar(request);
        VendaResponse response = responseMapper.modelToResponse(venda);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
