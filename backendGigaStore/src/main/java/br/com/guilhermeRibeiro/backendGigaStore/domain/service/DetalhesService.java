package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detalhes;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.DetalhesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalhesService {

    @Autowired
    private DetalhesRepository detalhesRepository;

    @Transactional
    public Detalhes cadastrar(Venda venda, Produto produto, Integer quantidadeProduto, Double valorProduto) {
        Detalhes detalhes = new Detalhes(venda, produto, quantidadeProduto, valorProduto);
        return detalhesRepository.save(detalhes);
    }

    public List<Detalhes> buscarDetalhesPorIdVenda(Long idVenda) {
        return detalhesRepository.findByVendaId(idVenda);
    }
}
