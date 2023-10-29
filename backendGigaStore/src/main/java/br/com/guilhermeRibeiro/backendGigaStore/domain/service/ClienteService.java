package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
}
