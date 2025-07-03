package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.entity.Cliente;
import com.deliverytech.delivery_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> listarAtivos() {
        return clienteRepository.findByAtivoTrue();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
            .map(cliente -> {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEndereco(clienteAtualizado.getEndereco());
                cliente.setAtivo(clienteAtualizado.isAtivo());
                return clienteRepository.save(cliente);
            })
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public void desativar(Long id) {
        clienteRepository.findById(id)
            .ifPresentOrElse(
                cliente -> {
                    cliente.setAtivo(false);
                    clienteRepository.save(cliente);
                },
                () -> {
                    throw new RuntimeException("Cliente não encontrado com ID: " + id);
                }
            );
    }
}
