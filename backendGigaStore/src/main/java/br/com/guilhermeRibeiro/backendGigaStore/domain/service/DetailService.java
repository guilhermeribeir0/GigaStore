package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detail;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.DetailsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DetailService {

    private final DetailsRepository detailsRepository;

    public DetailService(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    @Transactional
    public Detail registerDetails(Detail detail) {
        return detailsRepository.save(detail);
    }

    public List<Detail> findDetailsBySaleId(Long idVenda) {
        return detailsRepository.findBySaleId(idVenda);
    }
}
