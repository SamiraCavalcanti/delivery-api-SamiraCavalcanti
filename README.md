# Delivery Tech API

Sistema de delivery desenvolvido com Spring Boot e Java 21, pensado para ser escalável e moderno, servindo como base para uma startup inovadora no segmento de delivery.

---

## 🚀 Tecnologias

- **Java 21 LTS** (versão mais recente, garantindo performance e recursos modernos)
- Spring Boot 3.2.x
- Spring Web
- Spring Data JPA
- H2 Database (banco em memória para desenvolvimento)
- Maven (gerenciamento de dependências e build)

---

## ⚡ Recursos Modernos Utilizados

- **Records** (Java 14+) para modelagem simples e imutável de dados
- **Text Blocks** (Java 15+) para strings multilinha claras e legíveis
- **Pattern Matching** (Java 17+) para código mais expressivo e seguro
- **Virtual Threads** (Java 21) para melhor performance e escalabilidade

---

## 🏃‍♂️ Como executar

1. **Pré-requisitos:**  
   - Ter o **JDK 21** instalado e configurado no PATH  
   - Maven (opcional, pois o projeto já contém wrapper)

2. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/delivery-api-samiracavalcanti.git
   cd delivery-api-samiracavalcanti
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

| Endpoint      | Método | Descrição                                 |
| ------------- | ------ | ----------------------------------------- |
| `/health`     | GET    | Retorna status da aplicação e versão Java |
| `/info`       | GET    | Informações básicas do projeto            |
| `/h2-console` | GET    | Console web do banco H2 (em memória)      |



### 🔧 Configurações importantes

- Porta padrão do servidor: 8080

- Banco de dados: H2 em memória (configurado para criação e exclusão automática)

- Perfil de desenvolvimento ativado com DevTools para hot reload

## 👨‍💻 Desenvolvedora
Samira Cavalcanti - SDE TI 13 Arquitetura de Sistemas  
Desenvolvido com JDK 21.0.6 e Spring Boot 3.5.3




