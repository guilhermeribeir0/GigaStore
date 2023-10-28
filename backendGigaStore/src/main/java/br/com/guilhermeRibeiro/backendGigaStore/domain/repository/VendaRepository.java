package br.com.guilhermeRibeiro.backendGigaStore.domain.repository;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
