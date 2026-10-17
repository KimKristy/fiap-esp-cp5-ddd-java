package br.com.fiap.bank.core.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record CriarContaRequest(
    @NotBlank(message = "O CPF do cliente é obrigatório") String cpfCliente,
    String agencia,
    @NotNull(message = "O tipo de conta é obrigatório") String tipoConta,
    @NotNull(message = "O saldo inicial é obrigatório") @PositiveOrZero(message = "O saldo inicial não pode ser negativo") BigDecimal saldoInicial
) {}