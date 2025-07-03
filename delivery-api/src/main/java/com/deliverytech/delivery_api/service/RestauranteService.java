package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.entity.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    public List<Restaurante> listarAtivos() {
        return restauranteRepository.findByAtivoTrue();
    }

    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id);
    }

    public Optional<Restaurante> buscarPorCnpj(String cnpj) {
        return restauranteRepository.findByCnpj(cnpj);
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante atualizar(Long id, Restaurante restauranteAtualizado) {
        return restauranteRepository.findById(id)
            .map(restaurante -> {
                restaurante.setNome(restauranteAtualizado.getNome());
                restaurante.setCnpj(restauranteAtualizado.getCnpj());
                restaurante.setEndereco(restauranteAtualizado.getEndereco());
                restaurante.setAtivo(restauranteAtualizado.getAtivo());
                return restauranteRepository.save(restaurante);
            })
            .orElseThrow(() -> new RuntimeException("Restaurante não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        restauranteRepository.deleteById(id);
    }

    public void desativar(Long id) {
        restauranteRepository.findById(id)
            .ifPresentOrElse(
                restaurante -> {
                    restaurante.setAtivo(false);
                    restauranteRepository.save(restaurante);
                },
                () -> {
                    throw new RuntimeException("Restaurante não encontrado com ID: " + id);
                }
            );
    }
}
