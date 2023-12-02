package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoMinRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.venda.VendaRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Cliente;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Detalhes;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.ValidacaoException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private DetalhesService detalhesService;

    public List<Venda> listarVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        return vendas;
    }

    @Transactional(rollbackOn = Exception.class)
    public Venda cadastrar(VendaRequest request) {
        Cliente cliente = buscarClientePorId(request.getIdCliente());

        if (Objects.isNull(cliente)) {
            throw new RuntimeException(ValidacaoException.CLIENTE_NAO_ENCONTRADO);
        }

        Double totalVenda = definirValorTotalVenda(request.getProdutoMinRequest());

        Venda venda = new Venda(LocalDate.now(), cliente, totalVenda, false);
        Venda vendaSalva = vendaRepository.save(venda);

        cadastrarDetalhesVendas(vendaSalva, request.getProdutoMinRequest());

        return vendaSalva;
    }

    public Detalhes cadastrarDetalhesVendas(Venda venda, List<ProdutoMinRequest> requests) {
        Detalhes detalhes = new Detalhes();
        try {
            List<Produto> produtos = definirProdutosVenda(requests);
            for (Produto produto: produtos) {
                for (ProdutoMinRequest request: requests) {
                    detalhes = detalhesService.cadastrar(venda, produto, request.getQuantidade(), produto.getValor());
                    produtoService.saidaEstoque(produto.getId(), request.getQuantidade());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar detalhes da venda. " + e.getMessage());
        }
        return detalhes;
    }

    private Double definirValorTotalVenda(List<ProdutoMinRequest> produtos) {
        double total = 0.0;
        for (ProdutoMinRequest produto: produtos) {
            double valorProduto = buscarProdutoPorid(produto.getId()).getValor();
            total += valorProduto * produto.getQuantidade();
        }
        return total;
    }

    private List<Produto> definirProdutosVenda(List<ProdutoMinRequest> requests) {
        List<Produto> produtos = new ArrayList<>();
        List<Produto> produtosSemEstoque = new ArrayList<>();
        try {
            for (ProdutoMinRequest request: requests) {
                Produto produto = buscarProdutoPorid(request.getId());
                if (validaProdutosEstoque(produto, request.getQuantidade())) {
                    produtos.add(produto);
                } else {
                    produtosSemEstoque.add(produto);
                }
            }

            if (!validarProdutosVenda(produtos, requests)) {
                throw new RuntimeException(ValidacaoException.PRODUTO_ESTOQUE_INSUFICIENTE + produtosSemEstoque);
            }
            return produtos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao definir produtos da venda. " + e.getMessage());
        }
    }

    private boolean validarProdutosVenda(List<Produto> produtos, List<ProdutoMinRequest> requests) {
        return produtos.size() == requests.size();
    }

    private boolean validaProdutosEstoque(Produto produto, Integer quantidade) {
        return produto.getEstoque() >= quantidade;
    }

    private Cliente buscarClientePorId(Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (Objects.isNull(cliente)) {
            throw new RuntimeException(ValidacaoException.CLIENTE_NAO_ENCONTRADO);
        }
        return cliente;
    }

    private Produto buscarProdutoPorid(Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        if (Objects.isNull(produto)) {
            throw new RuntimeException(ValidacaoException.PRODUTO_NAO_ENCONTRADO);
        }
        return produto;
    }

}
