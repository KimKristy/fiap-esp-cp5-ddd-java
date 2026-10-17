package br.com.fiap.bank.core.infrastructure.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private BigDecimal rendaMensal;

    public ClienteEntity() {}

    public ClienteEntity(Long id, String cpf, String nome, String email, LocalDate dataNascimento, BigDecimal rendaMensal) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.rendaMensal = rendaMensal;
    }

    public Long getId() { return id; }
    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public BigDecimal getRendaMensal() { return rendaMensal; }
}