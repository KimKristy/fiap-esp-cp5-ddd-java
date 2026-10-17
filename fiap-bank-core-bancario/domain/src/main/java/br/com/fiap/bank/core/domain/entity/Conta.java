package br.com.fiap.bank.core.domain.entity;

import java.math.BigDecimal;

public class Conta {
    private Long id;
    private String numeroConta;
    private String agencia;
    private BigDecimal saldo;
    private String cpfCliente;
    private String tipoConta; // CORRENTE, POUPANCA, SALARIO
    private Boolean ativa;

    public Conta(Long id, String numeroConta, String agencia, BigDecimal saldo, String cpfCliente, String tipoConta) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo != null ? saldo : BigDecimal.ZERO;
        this.cpfCliente = cpfCliente;
        this.tipoConta = tipoConta;
        this.ativa = true;
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            raiseError("O valor do depósito deve ser maior que zero");
        }
        this.saldo = this.saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0 || this.saldo.compareTo(valor) < 0) {
            raiseError("Saldo insuficiente ou valor inválido para saque");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    private void raiseError(String msg) {
        throw new IllegalArgumentException(msg);
    }

    // Getters
    public Long getId() { return id; }
    public String getNumeroConta() { return numeroConta; }
    public String getAgencia() { return agencia; }
    public BigDecimal getSaldo() { return saldo; }
    public String getCpfCliente() { return cpfCliente; }
    public String getTipoConta() { return tipoConta; }
    public Boolean getAtiva() { return ativa; }
}