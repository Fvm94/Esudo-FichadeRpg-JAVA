Markdown

# 🐉 Guilda de Heróis - API (Backend)

Uma API RESTful desenvolvida em Java com Spring Boot para o gerenciamento de fichas de personagens de RPG (ideal para sistemas como Tormenta20 e D&D 5e). 

Este projeto atua como o backend do ecossistema "Guilda de Heróis", sendo responsável por persistir os dados em um banco relacional na nuvem e calcular matematicamente os modificadores de atributos dos personagens.

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando os padrões modernos da indústria de software:

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL (Produção e Local)
* **DevOps & Infraestrutura:**
  * **Docker:** Containerização com Multi-Stage Build.
  * **Docker Compose:** Orquestração do banco de dados para ambiente de desenvolvimento.
  * **GitHub Actions:** Esteira de CI/CD automatizada com banco de dados efêmero para testes automatizados.
  * **Render:** Hospedagem na nuvem com Continuous Deployment (CD).

## ⚙️ Funcionalidades e Arquitetura

* **Padrão MVC/Camadas:** Separação clara de responsabilidades entre Controllers, Services e Repositories.
* **DTOs com Records:** Transferência de dados enxuta e imutável.
* **Cálculo de Regras de Negócio:** Uso da Stream API para calcular automaticamente os modificadores com base nos valores base dos atributos.
* **Tratamento de Exceções:** Interceptador global (Controller Advice) para respostas padronizadas em caso de erros.
* **CORS Configurado:** API totalmente preparada para receber requisições de aplicações Front-end externas (ex: React).
* **Paridade de Ambientes:** Configuração dinâmica (`application.properties`) alternando entre variáveis de ambiente (Nuvem) e configurações locais de desenvolvimento.

## 🛠️ Como rodar o projeto localmente

### Pré-requisitos
* Java 21 instalado
* Maven instalado
* Docker e Docker Desktop/Engine rodando

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Fvm94/FichaRpg-Backend-JAVA.git
   cd FichaRpg-Backend-JAVA
   ```
2. Suba o Banco de Dados Local:
   
    O projeto conta com um arquivo docker-compose.yml pré-configurado.

    ```bash
    docker compose up -d
   ```
3. Inicie a Aplicação:
    Você pode iniciar pela sua IDE favorita ou pelo terminal usando o wrapper do Maven:

   ```bash

    ./mvnw spring-boot:run
   ````
   
    A API estará disponível em http://localhost:8080.

## 📦 Exemplo de Uso (Endpoints)

```POST /personagens```

Cria um novo herói e calcula seus modificadores de atributo.

Corpo da Requisição (JSON):
```JSON

{
  "nome": "Kaelen",
  "classe": "Bardo",
  "subclasse": "Colégio da Eloquência",
  "nivel": 5,
  "atributos": [
    { "nome": "Força", "valor": 8 },
    { "nome": "Destreza", "valor": 14 },
    { "nome": "Constituição", "valor": 12 },
    { "nome": "Inteligência", "valor": 10 },
    { "nome": "Sabedoria", "valor": 13 },
    { "nome": "Carisma", "valor": 18 }
  ]
}
```
```GET /personagens```
Retorna a lista completa de todos os heróis salvos no banco de dados.
