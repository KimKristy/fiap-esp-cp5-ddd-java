package br.com.fiap.bank.core.infrastructure.adapter;

import br.com.fiap.bank.core.domain.entity.Cliente;
import br.com.fiap.bank.core.domain.repository.ClienteRepository;
import br.com.fiap.bank.core.infrastructure.persistence.ClienteEntity;
import br.com.fiap.bank.core.infrastructure.persistence.SpringDataClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final SpringDataClienteRepository springDataRepository;

    public ClienteRepositoryAdapter(SpringDataClienteRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity(
            cliente.getId(), cliente.getCpf(), cliente.getNome(),
            cliente.getEmail(), cliente.getDataNascimento(), cliente.getRendaMensal()
        );
        ClienteEntity salvo = springDataRepository.save(entity);
        return new Cliente(salvo.getId(), salvo.getCpf(), salvo.getNome(), salvo.getEmail(), salvo.getDataNascimento(), salvo.getRendaMensal());
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return springDataRepository.findById(id)
            .map(e -> new Cliente(e.getId(), e.getCpf(), e.getNome(), e.getEmail(), e.getDataNascimento(), e.getRendaMensal()));
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return springDataRepository.findByCpf(cpf)
            .map(e -> new Cliente(e.getId(), e.getCpf(), e.getNome(), e.getEmail(), e.getDataNascimento(), e.getRendaMensal()));
    }

    @Override
    public List<Cliente> listarTodos() {
        return springDataRepository.findAll().stream()
            .map(e -> new Cliente(e.getId(), e.getCpf(), e.getNome(), e.getEmail(), e.getDataNascimento(), e.getRendaMensal()))
            .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        springDataRepository.deleteById(id);
    }
}