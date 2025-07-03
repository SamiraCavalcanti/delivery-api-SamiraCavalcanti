package com.deliverytech.delivery_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private Boolean ativo = true; // Restaurante ativo por padrão

    public Boolean getAtivo() {
        return ativo != null ? ativo : true;
    }

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore // Evita recursão infinita e lazy loading issues
    private List<Produto> cardapio;
}