package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

}
