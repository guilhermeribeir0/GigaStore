package br.com.guilhermeRibeiro.backendGigaStore.domain.exception;

public class ValidacaoException {

    public static final String CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado.";
    public static final String CLIENTE_INATIVO = "Cliente com cadastro desativado";
    public static final String PRODUTO_NAO_ENCONTRADO = "Produto não encontrado.";
    public static final String PRODUTO_INATIVO = "Produto com cadastro desativado";
    public static final String PRODUTO_ESTOQUE_INSUFICIENTE = "Produto sem estoque ou com estoque insuficiente para finalização da venda";

}
