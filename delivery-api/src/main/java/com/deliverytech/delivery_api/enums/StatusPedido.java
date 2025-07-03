package com.deliverytech.delivery_api.enums;

/**
 * Enumeração que representa os possíveis status de um pedido.
 * 
 * PENDENTE: Pedido criado, aguardando confirmação.
 * CONFIRMADO: Pedido confirmado, aguardando preparação.
 * PREPARANDO: Pedido em preparação.
 * SAIU_PARA_ENTREGA: Pedido saiu para entrega.
 * ENTREGUE: Pedido entregue ao cliente.
 * CANCELADO: Pedido cancelado.
 */


public enum StatusPedido {
    PENDENTE,
    CONFIRMADO,
    PREPARANDO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO
}
 