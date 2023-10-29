package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

}
