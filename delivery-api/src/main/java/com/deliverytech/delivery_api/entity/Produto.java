package com.deliverytech.delivery_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponivel = true; // Produto disponível por padrão

    public Boolean getDisponivel() {
        return disponivel != null ? disponivel : true;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id")
    @JsonIgnore // Evita recursão infinita ao serializar para JSON
    private Restaurante restaurante;
}