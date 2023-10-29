package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.DetalhesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalhesService {

    @Autowired
    private DetalhesRepository detalhesRepository;
}
