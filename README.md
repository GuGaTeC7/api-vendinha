# API para CRUD de Vendas, Produtos e Usuários

Esta é uma API desenvolvida em **Java** utilizando o **Spring Boot**, que permite realizar operações de **CRUD (Create, Read, Update, Delete)** sobre vendas, produtos e usuários. O projeto tem como objetivo fornecer uma interface de backend robusta para gerenciar dados de um sistema de vendas.

## Tecnologias Utilizadas

O projeto faz uso de bibliotecas e ferramentas essenciais do ecossistema Java/Spring para facilitar o desenvolvimento e garantir a escalabilidade e manutenibilidade da aplicação. Algumas das principais tecnologias e bibliotecas utilizadas incluem:

- **Spring Boot**: Framework principal para simplificar o desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para abstração e manipulação de dados, utilizando o padrão de repositório e integração com bancos de dados relacionais.
- **MySQL Connector**: Driver JDBC utilizado para a conexão e manipulação de dados no banco de dados MySQL.
- **Lombok**: Biblioteca para simplificar o código Java, reduzindo a necessidade de métodos boilerplate como getters, setters e construtores.
- **Spring Web**: Utilizado para a criação de endpoints RESTful e comunicação HTTP.

## Funcionalidades

A API oferece os seguintes recursos e operações:

- **Gerenciamento de Produtos**: Criação, leitura, atualização e exclusão de produtos.
- **Gerenciamento de Usuários**: Operações de CRUD para manter os dados dos usuários.
- **Registro de Vendas**: Criação de novas vendas com controle de estoque, associando produtos aos usuários.

## Estrutura do Projeto

O projeto segue uma arquitetura limpa, com a separação de responsabilidades em camadas (Controller, Service, Repository), facilitando a manutenção e a escalabilidade do código. 

- **Controller**: Define os endpoints da API e mapeia as requisições HTTP.
- **Service**: Implementa a lógica de negócios.
- **Repository**: Interface para comunicação com o banco de dados, utilizando Spring Data JPA.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/GuGaTeC7/api-vendinha
   ```
2. Configure o banco de dados MySQL no arquivo `application.properties` ou `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/seu-banco
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

A API estará disponível em `http://localhost:8080`.

## Endpoints Principais

### Produtos

- **GET** `/produtos`  
  Retorna todos os produtos

- **GET** `/produtos/{id}`  
  Retorna um produtos baseado no id

- **POST** `/produtos`  
  Adiciona um novo produto

- **PUT** `/produtos/{id}`  
  Atualiza um produto existente

- **DELETE** `/produtos/{id}`  
  Remove um produto

### Usuários

- **GET** `/users`  
  Retorna todos os usuários

- **GET** `/users/{id}`
  Retorna um usuário baseado no id

- **POST** `/users`  
  Adiciona um novo usuário

- **PUT** `/users/{id}`  
  Atualiza um usuário existente

- **DELETE** `/users/{id}`  
  Remove um usuário

### Vendas

- **GET** `/vendas`  
  Retorna todos os usuários

- **GET** `/vendas/{id}`  
  Retorna os detalhes de uma venda
  
- **POST** `/vendas`  
  Registra uma nova venda


## Dependências

As principais dependências utilizadas neste projeto incluem:

- **spring-boot-starter-data-jpa**: Para integração com o banco de dados.
- **spring-boot-starter-web**: Para a criação de endpoints RESTful.
- **mysql-connector-java**: Driver JDBC para conexão com MySQL.
- **lombok**: Redução de boilerplate no código Java.

## Contribuição

Contribuições são bem-vindas! Caso tenha sugestões de melhorias ou correções, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Integrantes do Grupo:

- **Gustavo Luiz da Silva**  
  RA: 2301710

- **Juan Pablo Gomes de Andrade**  
  RA: 2301387

- **Kauan Bulgaroni Silva**  
  RA: 2202097

- **Erick Siqueira Munarin**  
  RA: 2301901

- **Andson Eloi da Silva**  
  RA: 2301714

- **Alan Givaldo Rojas Ticona**  
  RA: 2301633
