package br.com.guilhermeRibeiro.backendGigaStore.domain.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "t_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @CPF
    @Min(11)
    @Max(11)
    private String cpf;
    @Email
    private String email;
    private boolean ativo;
}
