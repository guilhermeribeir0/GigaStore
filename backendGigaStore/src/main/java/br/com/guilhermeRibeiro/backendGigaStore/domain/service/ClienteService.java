package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.cliente.ClienteRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.produto.ProdutoRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.cliente.ClienteResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Cliente;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Produto;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.ValidacaoException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new RuntimeException(ValidacaoException.CLIENTE_NAO_ENCONTRADO + " - Id: " + id);
        }
        return cliente.get();
    }

    public Cliente buscarClientePorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        if (cliente.isEmpty()) {
            throw new RuntimeException(ValidacaoException.CLIENTE_NAO_ENCONTRADO + " - CPF: " + cpf);
        }
        return cliente.get();
    }

    @Transactional
    public Cliente cadastrarCliente(ClienteRequest request) {
        try {
            Cliente cliente = new Cliente(request);
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar cliente." + e.getMessage());
        }
    }

    @Transactional
    public Cliente alterarAtivo(Long id) {
        Optional<Cliente> cliente = Optional.of(clienteRepository.findById(id)
                .map(cli -> {
                    if (cli.isAtivo()) {
                        cli.setAtivo(false);
                    } else {
                        cli.setAtivo(true);
                    }
                    return clienteRepository.save(cli);
                }).orElseThrow(() -> new RuntimeException(ValidacaoException.CLIENTE_NAO_ENCONTRADO)));
        return cliente.get();
    }
}
