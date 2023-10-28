package br.com.guilhermeRibeiro.backendGigaStore.domain.repository;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detalhes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhesRepository extends JpaRepository<Detalhes, Long> {
}
