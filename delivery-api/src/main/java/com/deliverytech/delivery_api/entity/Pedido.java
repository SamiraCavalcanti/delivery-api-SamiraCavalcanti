package com.deliverytech.delivery_api.entity;

import com.deliverytech.delivery_api.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroPedido;
    private LocalDateTime dataPedido;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private String observacoes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ItemPedido> itens = new ArrayList<>();

    @PrePersist
    public void gerarNumeroPedido() {
        if (numeroPedido == null) {
            this.numeroPedido = "PED-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            this.dataPedido = LocalDateTime.now();
        }
    }

    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item);
        calcularTotal();
    }

    public void calcularTotal() {
        this.valorTotal = itens.stream()
            .map(ItemPedido::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void confirmar() {
        this.status = StatusPedido.CONFIRMADO;
        calcularTotal();
    }
}