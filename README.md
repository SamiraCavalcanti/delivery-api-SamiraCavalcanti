# Delivery Tech API

Sistema de delivery desenvolvido com Spring Boot e Java 21, pensado para ser escalável e moderno, servindo como base para uma startup inovadora no segmento de delivery.

---

## 🚀 Tecnologias

- **Java 21 LTS** (versão mais recente, garantindo performance e recursos modernos)
- **Spring Boot 3.5.3** (framework principal)
- **Spring Web** (para APIs REST)
- **Spring Data JPA** (persistência de dados)
- **Hibernate** (ORM)
- **H2 Database** (banco em memória para desenvolvimento)
- **Lombok** (redução de boilerplate)
- **Maven** (gerenciamento de dependências e build)

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas bem definida:

- **Controller Layer**: Endpoints REST (`@RestController`)
- **Entity Layer**: Modelos de dados JPA (`@Entity`) 
- **Repository Layer**: Acesso a dados (`@Repository`)
- **Service Layer**: Lógica de negócio (implícita nos Controllers para este MVP)

### 📊 Modelo de Dados

- **Cliente**: Informações pessoais e de contato
- **Restaurante**: Dados do estabelecimento e cardápio
- **Produto**: Itens do cardápio com preços
- **Pedido**: Relaciona cliente, restaurante e produtos

---

## 🏃‍♂️ Como executar

1. **Pré-requisitos:**  
   - Ter o **JDK 21** instalado e configurado no PATH  
   - Maven (opcional, pois o projeto já contém wrapper)

2. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/delivery-api.git
   cd delivery-api
    ```
  

3. Execute a aplicação   
   ```bash
   ./mvnw spring-boot:run
    ```
4. Acesse o endpoint de health check no navegador ou via curl:
     ```bash
   http://localhost:8080/health
    ```

### 📋 Endpoints disponíveis

#### 🏥 Sistema e Saúde
| Endpoint      | Método | Descrição                                 |
| ------------- | ------ | ----------------------------------------- |
| `/`           | GET    | Página inicial da API (Hello World)      |
| `/health`     | GET    | Retorna status da aplicação e versão Java |
| `/h2-console` | GET    | Console web do banco H2 (em memória)      |

#### 👥 Clientes
| Endpoint              | Método | Descrição                    |
| --------------------- | ------ | ---------------------------- |
| `/api/clientes`       | GET    | Lista todos os clientes      |
| `/api/clientes`       | POST   | Cria um novo cliente         |
| `/api/clientes/{id}`  | GET    | Busca cliente por ID         |

#### 🏪 Restaurantes  
| Endpoint                  | Método | Descrição                      |
| ------------------------- | ------ | ------------------------------ |
| `/api/restaurantes`       | GET    | Lista todos os restaurantes    |
| `/api/restaurantes`       | POST   | Cria um novo restaurante       |
| `/api/restaurantes/{id}`  | GET    | Busca restaurante por ID       |

#### 🍕 Produtos
| Endpoint              | Método | Descrição                    |
| --------------------- | ------ | ---------------------------- |
| `/api/produtos`       | GET    | Lista todos os produtos      |
| `/api/produtos`       | POST   | Cria um novo produto         |
| `/api/produtos/{id}`  | GET    | Busca produto por ID         |

#### 📦 Pedidos
| Endpoint              | Método | Descrição                    |
| --------------------- | ------ | ---------------------------- |
| `/api/pedidos`        | GET    | Lista todos os pedidos       |
| `/api/pedidos`        | POST   | Cria um novo pedido          |
| `/api/pedidos/{id}`   | GET    | Busca pedido por ID          |

### 🗄️ Dados de Exemplo

A aplicação já vem com dados pré-carregados para teste:

- **2 Clientes**: João Silva e Maria Oliveira
- **2 Restaurantes**: Pizzaria do Zé e Hamburgueria Top  
- **6 Produtos**: Pizzas, hambúrgueres, refrigerantes e batata frita
- **1 Pedido**: Pedido exemplo com pizzas do João Silva

### 🔧 Acesso ao Banco H2

Para visualizar os dados no banco:

1. Acesse: `http://localhost:8080/h2-console`
2. Use as configurações:
   - **JDBC URL**: `jdbc:h2:mem:deliverydb`
   - **User**: `sa`
   - **Password**: (deixe em branco)

### 💡 Exemplos de Uso

#### 🔧 Testando com Postman

**1. Listar Restaurantes (GET)**
- **URL**: `http://localhost:8080/api/restaurantes`
- **Method**: GET
- **Headers**: Não precisa

**2. Criar Novo Restaurante (POST)**
- **URL**: `http://localhost:8080/api/restaurantes`
- **Method**: POST
- **Body** (aba "Body"):
  - Selecione "raw" 
  - No dropdown ao lado, mude para **"JSON"** (isso adiciona automaticamente o Content-Type)
```json
{
  "nome": "Lanchonete da Esquina",
  "cnpj": "55.666.777/0001-88",
  "endereco": "Rua das Palmeiras, 200, Rio de Janeiro"
}
```
**Resultado esperado**: 
```json
{
  "id": 5,
  "nome": "Lanchonete da Esquina", 
  "cnpj": "55.666.777/0001-88",
  "endereco": "Rua das Palmeiras, 200, Rio de Janeiro"
}
```

**3. Criar Novo Cliente (POST)**
- **URL**: `http://localhost:8080/api/clientes`
- **Method**: POST
- **Body** (raw → JSON):
```json
{
  "nome": "Ana Costa",
  "email": "ana@email.com",
  "telefone": "(11)99999-9999",
  "endereco": "Rua Nova, 456"
}
```

**4. Criar Novo Produto (POST)**
- **URL**: `http://localhost:8080/api/produtos`
- **Method**: POST
- **Body** (raw → JSON):
```json
{
  "nome": "Temaki Salmão",
  "descricao": "Temaki com salmão fresco e pepino",
  "preco": 25.90,
  "restaurante": {
    "id": 3
  }
}
```

#### 🖥️ Testando com curl (terminal)

```bash
# Listar todos os clientes
curl http://localhost:8080/api/clientes

# Listar todos os restaurantes  
curl http://localhost:8080/api/restaurantes

# Listar todos os pedidos
curl http://localhost:8080/api/pedidos

# Criar um novo restaurante
curl -X POST http://localhost:8080/api/restaurantes \
  -H "Content-Type: application/json" \
  -d '{"nome":"Sushi House","cnpj":"11.222.333/0001-44","endereco":"Rua do Sushi, 100, São Paulo"}'

# Criar um novo cliente
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{"nome":"Ana Costa","email":"ana@email.com","telefone":"(11)99999-9999","endereco":"Rua Nova, 456"}'
```

### 📝 Passos no Postman

1. **Abra o Postman**
2. **Crie uma nova request**
3. **Para listar** (GET):
   - Cole a URL: `http://localhost:8080/api/restaurantes`
   - Clique em "Send"

4. **Para criar** (POST):
   - Cole a URL: `http://localhost:8080/api/restaurantes`  
   - Mude o método para "POST"
   - **Body**: Vá na aba "Body"
     - Selecione "raw" 
     - No dropdown ao lado, mude de "Text" para **"JSON"** ✅
     - Cole o JSON do exemplo
   - Clique em "Send"

> **⚠️ Importante**: O CNPJ deve ser único! Se você tentar usar um CNPJ que já existe, receberá um erro 500. Use CNPJs diferentes para cada teste.

### 🔍 Dicas Importantes para Postman

**✅ Configuração Correta:**
1. **Body**: Na aba "Body" → Selecione "raw" → No dropdown, mude de "Text" para **"JSON"** (isso adiciona automaticamente o Content-Type)
2. **JSON válido**: Certifique-se de que o JSON está bem formatado (use aspas duplas)

**❌ Erros Comuns:**
- Deixar o Body em "Text" ao invés de "JSON"
- Usar aspas simples no JSON ao invés de aspas duplas
- Não selecionar "raw" no Body



### 🔧 Configurações importantes

- Porta padrão do servidor: 8080

- Banco de dados: H2 em memória (configurado para criação e exclusão automática)

- Perfil de desenvolvimento ativado com DevTools para hot reload

## 👨‍💻 Desenvolvedora
Samira Cavalcanti - SDE TI 13 Arquitetura de Sistemas  
Desenvolvido com JDK 21.0.6 e Spring Boot 3.5.3




