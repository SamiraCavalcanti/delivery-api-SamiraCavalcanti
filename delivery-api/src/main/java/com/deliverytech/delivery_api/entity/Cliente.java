package com.deliverytech.delivery_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Anotação Lombok para getters, setters, etc.
public class Cliente {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private Boolean ativo = true; // Cliente ativo por padrão

    public boolean isAtivo() {
        return ativo != null ? ativo : true;
    }

    // @OneToMany(mappedBy = "cliente")
    // private List<Pedido> pedidos;
}