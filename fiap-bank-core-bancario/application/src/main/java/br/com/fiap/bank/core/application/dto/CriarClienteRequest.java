package br.com.fiap.bank.core.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarClienteRequest(
    @NotBlank(message = "O CPF é obrigatório") String cpf,
    @NotBlank(message = "O nome é obrigatório") String nome,
    @NotBlank(message = "O e-mail é obrigatório") @Email(message = "E-mail inválido") String email,
    @NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento,
    @NotNull(message = "A renda mensal é obrigatória") @PositiveOrZero(message = "A renda deve ser positiva") BigDecimal rendaMensal
) {}