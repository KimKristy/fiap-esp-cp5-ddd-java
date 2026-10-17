package br.com.fiap.bank.core.domain.entity;

import java.time.LocalDate;
import java.math.BigDecimal;

public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private BigDecimal rendaMensal;

    public Cliente(Long id, String cpf, String nome, String email, LocalDate dataNascimento, BigDecimal rendaMensal) {
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