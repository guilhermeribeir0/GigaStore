package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.ValidacaoException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new RuntimeException(ValidacaoException.PRODUTO_NAO_ENCONTRADO + " - Id: " + id);
        }
        return produto.get();
    }

    @Transactional
    public Produto cadastrarProduto(ProdutoRequest request) {
        try {
            Produto produto = new Produto(request);
            return produtoRepository.save(produto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar produto." + e.getMessage());
        }
    }

    public Produto atualizarProduto(Long id, ProdutoRequest request) {
        Produto produto = produtoRepository.findById(id)
                .map(prod -> {
                    prod.setNome(request.getNome());
                    prod.setReferencia(request.getReferencia());
                    prod.setValor(request.getValor());
                    return produtoRepository.save(prod);
                }).orElseThrow(() -> new RuntimeException(ValidacaoException.PRODUTO_NAO_ENCONTRADO));
        return produto;
    }

    public Produto entradaEstoque(Long id, Integer quantidade) {
        Produto produto = produtoRepository.findById(id)
                .map(prod -> {
                    prod.setEstoque(prod.getEstoque() + quantidade);
                    return produtoRepository.save(prod);
                }).orElseThrow(() -> new RuntimeException(ValidacaoException.PRODUTO_NAO_ENCONTRADO));
        return produto;
    }

    public Produto saidaEstoque(Long id, Integer quantidade) {
        Produto produto = produtoRepository.findById(id)
                .map(prod -> {
                    prod.setEstoque(prod.getEstoque() - quantidade);
                    return produtoRepository.save(prod);
                }).orElseThrow(() -> new RuntimeException(ValidacaoException.PRODUTO_NAO_ENCONTRADO));
        return produto;
    }

    @Transactional
    public Produto alterarAtivo(Long id) {
        Produto produto = (produtoRepository.findById(id)
                .map(prod -> {
                    if (prod.isAtivo()) {
                        prod.setAtivo(false);
                    } else {
                        prod.setAtivo(true);
                    }
                    return produtoRepository.save(prod);
                }).orElseThrow(() -> new RuntimeException(ValidacaoException.PRODUTO_NAO_ENCONTRADO)));
        return produto;
    }
}
