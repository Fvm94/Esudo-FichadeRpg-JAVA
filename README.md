# 🐉 API REST - Gerenciador de Fichas de RPG

Uma API RESTful desenvolvida em Java e Spring Boot para gerenciar fichas e personagens de RPG de mesa, inspirada nas mecânicas de sistemas como D&D 5e e Tormenta20.

Este projeto foi construído com foco em boas práticas de arquitetura, utilização de recursos modernos do Java e tratamento robusto de erros, servindo como base para estudos de deploy e CI/CD.

## 🚀 Tecnologias e Práticas Utilizadas

* **Java 17+:** Uso de `Records` para DTOs, `Optional` e *Stream API* para cálculo dinâmico de regras de negócio.
* **Spring Boot (Web & Data JPA):** Inversão de Controle, Injeção de Dependência e mapeamento objeto-relacional.
* **Banco de Dados H2:** Banco em memória para facilitar testes e desenvolvimento ágil.
* **Tratamento Global de Exceções:** Uso de `@RestControllerAdvice` para padronização de respostas de erro (ex: 404 Not Found customizado).
* **Validação de Dados:** *Bean Validation* (ex: `@NotBlank`, `@Positive`) garantindo a integridade das requisições.

## ⚙️ Funcionalidades

- `POST /personagens`: Cria uma nova ficha de personagem. Calcula automaticamente os modificadores de cada atributo recebido utilizando a regra padrão (Valor - 10) / 2.
- `GET /personagens`: Retorna a lista de todos os personagens cadastrados.
- `GET /personagens/{id}`: Busca um personagem específico pelo ID. Retorna erro 404 estruturado caso não exista.

## 🛠️ Como executar o projeto localmente

1. Clone este repositório.
2. Certifique-se de ter o Java 17 (ou superior) e o Maven instalados.
3. Navegue até a raiz do projeto e execute:
   ```bash
   mvn spring-boot:run