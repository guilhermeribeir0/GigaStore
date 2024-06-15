package br.com.guilhermeRibeiro.backendGigaStore.domain.repository;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<Detail, Long> {

    List<Detail> findBySaleId(Long id);
}
