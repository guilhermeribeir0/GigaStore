package br.com.guilhermeRibeiro.backendGigaStore.domain.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super(createdMessageId(id));
    }

    public CustomerNotFoundException(String cpf) {
        super(createdMessageCpf(cpf));
    }

    private static String createdMessageId(Long id) {
        return String.format("Cliente nao encontrado.\nId: %d", id);
    }

    private static String createdMessageCpf(String cpf) {
        return String.format("Cliente nao encontrado.\nCPF: %s", cpf);
    }
}
