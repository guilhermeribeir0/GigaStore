package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.cliente.ClienteRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.cliente.ClienteResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Cliente;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.cliente.ClienteResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteResponseMapper responseMapper;

    @GetMapping
    public @ResponseBody ResponseEntity<List<ClienteResponse>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        List<ClienteResponse> responses = responseMapper.modelListToResponseList(clientes);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}")
    public @ResponseBody ResponseEntity<ClienteResponse> buscaClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        ClienteResponse response = responseMapper.modelToResponse(cliente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "cpf/{cpf}")
    public @ResponseBody ResponseEntity<ClienteResponse> buscaClientePorId(@PathVariable String cpf) {
        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
        ClienteResponse response = responseMapper.modelToResponse(cliente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest request) {
        Cliente cliente = clienteService.cadastrarCliente(request);
        ClienteResponse response = responseMapper.modelToResponse(cliente);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping(value = "alterarAtivo/{id}")
    public @ResponseBody ResponseEntity<ClienteResponse> alterarAtivoCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.alterarAtivo(id);
        ClienteResponse response = responseMapper.modelToResponse(cliente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
