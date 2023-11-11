package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.venda.VendaRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Cliente;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Venda;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.ValidacaoException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.VendaRepository;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    public List<Venda> listarVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        return vendas;
    }

    @Transactional
    public Venda cadastrar(VendaRequest request) {
        try {
            Cliente cliente = buscarClientePorId(request.getIdCliente());
            LocalDate dataVenda = LocalDate.now();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao finalizar venda. " + e.getMessage());
        }
    }

    private boolean validaProdutosEstoque(VendaRequest request) {

    }

    private Cliente buscarClientePorId(Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (Objects.isNull(cliente)) {
            throw new RuntimeException(ValidacaoException.CLIENTE_NAO_ENCONTRADO);
        }
        return cliente;
    }

    private Optional<Produto> buscarProdutoPorid(Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        if (Objects.isNull(produto)) {
            return Optional.empty();
        }
        return Optional.of(produto);
    }

}
