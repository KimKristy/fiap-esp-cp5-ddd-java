package br.com.fiap.bank.core.domain.repository;

import br.com.fiap.bank.core.domain.entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorId(Long id);
    Optional<Cliente> buscarPorCpf(String cpf);
    List<Cliente> listarTodos();
    void deletar(Long id);
}