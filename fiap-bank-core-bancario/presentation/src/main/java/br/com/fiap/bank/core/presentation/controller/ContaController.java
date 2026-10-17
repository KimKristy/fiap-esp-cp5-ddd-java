package br.com.fiap.bank.core.presentation.controller;

import br.com.fiap.bank.core.application.dto.CriarContaRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody @Valid CriarContaRequest request) {
        // Lógica de criação de conta mapeada para o padrão RESTful (201 Created)
        return ResponseEntity.status(HttpStatus.CREATED).body("Conta criada com sucesso para o CPF: " + request.cpfCliente());
    }

    @GetMapping
    public ResponseEntity<String> listar() {
        return ResponseEntity.ok("Listagem de contas do Core Bancário");
    }
}