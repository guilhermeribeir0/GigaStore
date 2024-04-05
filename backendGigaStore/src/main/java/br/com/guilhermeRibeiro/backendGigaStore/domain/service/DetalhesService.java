package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detalhes;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.DetalhesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DetalhesService {

    private final DetalhesRepository detalhesRepository;

    public DetalhesService(DetalhesRepository detalhesRepository) {
        this.detalhesRepository = detalhesRepository;
    }

    @Transactional
    public Detalhes cadastrar(Detalhes detalhes) {
        return detalhesRepository.save(detalhes);
    }

    public List<Detalhes> buscarDetalhesPorIdVenda(Long idVenda) {
        return detalhesRepository.findByVendaId(idVenda);
    }
}
