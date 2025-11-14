📝 Guia Rápido: README para API-RESTful (sheylavaz/API-RESTful)

🏆 API RESTful de Exemplo

Exemplo de implementação de uma API RESTful utilizando Spring Boot 3, Spring Data JPA e H2 Database para gerenciamento de dados de usuários.

🚀 Tecnologias Utilizadas
O projeto foi construído com as seguintes ferramentas e frameworks:

Java 17+

Spring Boot 3.3.0 (ou a versão estável utilizada)

Spring Web: Para criar os endpoints RESTful.

Spring Data JPA: Para a persistência de dados.

H2 Database: Banco de dados em memória, ideal para desenvolvimento e testes.

Lombok: Para reduzir o código boilerplate (getters/setters, construtores).

SpringDoc OpenAPI (Swagger UI): Para documentação e teste interativo da API.

⚙️ Configuração e Execução

Pré-requisitos

Certifique-se de ter o JDK 17 ou superior e o Maven instalados em sua máquina.

Execução Local

1- Clone o Repositório:

Bash

git clone https://github.com/sheylavaz/API-RESTful.git
cd API-RESTful

2- Compile e Execute com Maven:

Bash

mvn clean install
mvn spring-boot:run

📚 Documentação da API (Swagger UI)
A documentação interativa da API está disponível através do Swagger UI.

Endpoint de Documentação: http://localhost:8080/swagger-ui/index.html

Use esta interface para visualizar todos os endpoints disponíveis (GET, POST, DELETE, etc.).

🗺️ Endpoints Principais
A API gerencia o recurso Usuário.

Método		Endpoint		Descrição

GET			/users			Lista todos os usuários cadastrados.

GET			/users/{id}		Busca um usuário específico pelo ID.

POST		/users			Cria um novo usuário.

DELETE		/users/{id}		Remove um usuário existente pelo ID.


