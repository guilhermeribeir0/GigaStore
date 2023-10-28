package br.com.guilhermeRibeiro.backendGigaStore.domain.repository;

import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
