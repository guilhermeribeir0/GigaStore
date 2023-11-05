package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_detalhes")
public class Detalhes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;
    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @Column(name = "quantidade_produto")
    private Integer quanatidadeProduto;
    @Column(name = "valor_produto")
    private BigDecimal valorProduto;

    public Detalhes() {
    }

    public Detalhes(Venda venda, Produto produto, Integer quanatidadeProduto, BigDecimal valorProduto) {
        this.venda = venda;
        this.produto = produto;
        this.quanatidadeProduto = quanatidadeProduto;
        this.valorProduto = valorProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuanatidadeProduto() {
        return quanatidadeProduto;
    }

    public void setQuanatidadeProduto(Integer quanatidadeProduto) {
        this.quanatidadeProduto = quanatidadeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }
}
