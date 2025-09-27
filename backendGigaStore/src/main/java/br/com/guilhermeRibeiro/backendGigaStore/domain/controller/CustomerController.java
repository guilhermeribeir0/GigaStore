package br.com.guilhermeRibeiro.backendGigaStore.domain.controller;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.customer.CustomerRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.response.customer.CustomerResponse;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import br.com.guilhermeRibeiro.backendGigaStore.domain.mapper.cliente.CustomerResponseMapper;
import br.com.guilhermeRibeiro.backendGigaStore.domain.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerResponseMapper responseMapper;

    public CustomerController(
            CustomerService customerService,
            CustomerResponseMapper responseMapper
    ) {
        this.customerService = customerService;
        this.responseMapper = responseMapper;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<CustomerResponse>> findAllClients() {
        List<Customer> customers = customerService.findAllClients();
        List<CustomerResponse> responses = responseMapper.modelListToResponseList(customers);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/findClient/{id}")
    public @ResponseBody ResponseEntity<CustomerResponse> findClientById(@PathVariable("id") Long id) {
        Customer customer = customerService.findClientById(id);
        CustomerResponse response = responseMapper.modelToResponse(customer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/findClient/{cpf}")
    public @ResponseBody ResponseEntity<CustomerResponse> findClientByCpf(@PathVariable("cpf") String cpf) {
        Customer customer = customerService.findClientByCpf(cpf);
        CustomerResponse response = responseMapper.modelToResponse(customer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/registerClient")
    public @ResponseBody ResponseEntity<CustomerResponse> registerClient(@RequestBody CustomerRequest request) {
        Customer customer = customerService.registerClient(request);
        CustomerResponse response = responseMapper.modelToResponse(customer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/changeActive/{id}")
    public @ResponseBody ResponseEntity<CustomerResponse> changeActive(@PathVariable("id") Long id) {
        Customer customer = customerService.changeActive(id);
        CustomerResponse response = responseMapper.modelToResponse(customer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
