package br.com.guilhermeRibeiro.backendGigaStore.domain.service;

import br.com.guilhermeRibeiro.backendGigaStore.domain.dto.request.cliente.CustomerRequest;
import br.com.guilhermeRibeiro.backendGigaStore.domain.entity.Customer;
import br.com.guilhermeRibeiro.backendGigaStore.domain.exception.CustomerNotFoundException;
import br.com.guilhermeRibeiro.backendGigaStore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllClients() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer findClientById(Long id) {
        Optional<Customer> cliente = customerRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new CustomerNotFoundException(id);
        }
        return cliente.get();
    }

    public Customer findClientByCpf(String cpf) {
        Optional<Customer> cliente = customerRepository.findByCpf(cpf);
        if (cliente.isEmpty()) {
            throw new CustomerNotFoundException(cpf);
        }
        return cliente.get();
    }

    @Transactional
    public Customer registerClient(CustomerRequest request) {
        try {
            Customer customer = new Customer(request);
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException("Error when registering customer." + e.getMessage());
        }
    }

    @Transactional
    public Customer changeActive(Long id) {
        Optional<Customer> cliente = customerRepository.findById(id);

        if (cliente.isEmpty()) {
            throw new CustomerNotFoundException(id);
        }

        cliente.get().setActive(!cliente.get().isActive());
        return customerRepository.save(cliente.get());
    }
}
