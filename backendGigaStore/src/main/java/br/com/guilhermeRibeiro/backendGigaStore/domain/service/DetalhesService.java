package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detalhes;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.DetalhesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class DetalhesService {

    @Autowired
    private DetalhesRepository detalhesRepository;

    @Transactional
    public void cadastrar(Venda venda, Produto produto, Integer quantidadeProduto, BigDecimal valorProduto) {
        Detalhes detalhes = new Detalhes(venda, produto, quantidadeProduto, valorProduto);
        detalhesRepository.save(detalhes);
    }
}
