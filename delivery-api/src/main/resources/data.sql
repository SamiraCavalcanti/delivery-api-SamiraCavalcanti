-- Dados de exemplo para testes

-- Inserir clientes
INSERT INTO cliente (nome, email, telefone, endereco, ativo) VALUES
('João Silva', 'joao@email.com', '(11) 99999-1111', 'Rua A, 123 - São Paulo/SP', true),
('Maria Santos', 'maria@email.com', '(11) 99999-2222', 'Rua B, 456 - São Paulo/SP', true);

-- Inserir restaurantes
INSERT INTO restaurante (nome, cnpj, endereco, ativo) VALUES
('Pizzaria do Zé', '12.345.678/0001-99', 'Rua da Pizza, 10, São Paulo', true),
('Hamburgueria Top', '98.765.432/0001-11', 'Av. dos Lanches, 20, Rio de Janeiro', true);

-- Inserir produtos
INSERT INTO produto (nome, descricao, preco, disponivel, restaurante_id) VALUES
-- Pizzaria do Zé
('Pizza Margherita', 'Pizza tradicional com tomate e manjericão', 35.90, true, 1),
('Pizza Calabresa', 'Pizza com calabresa e cebola', 38.90, true, 1),
('Refrigerante', 'Coca-Cola 350ml', 5.90, true, 1),

-- Hamburgueria Top  
('X-Burger', 'Hambúrguer com queijo, alface e tomate', 18.90, true, 2),
('X-Bacon', 'Hambúrguer com bacon, queijo, alface e tomate', 22.90, true, 2),
('Batata Frita', 'Porção de batata frita', 12.90, true, 2);

-- Inserir um pedido de exemplo
INSERT INTO pedido (numero_pedido, data_pedido, status, valor_total, observacoes, cliente_id, restaurante_id) VALUES
('PED-12345678', NOW(), 'PENDENTE', 54.80, 'Sem cebola', 1, 1);

-- Inserir itens do pedido
INSERT INTO item_pedido (quantidade, preco_unitario, subtotal, pedido_id, produto_id) VALUES
(1, 35.90, 35.90, 1, 1), -- Pizza Margherita
(1, 38.90, 38.90, 1, 2), -- Pizza Calabresa  
(2, 5.90, 11.80, 1, 3);  -- 2 Refrigerantes