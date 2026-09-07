# Países API

API RESTful desenvolvida em Java e Spring Boot
para gerenciamento de informações de países.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- OpenAPI / Swagger

## Funcionalidades

- Criar país
- Listar países
- Consultar país por ID
- Atualizar país
- Eliminar país
- Ordenar países por propriedade

## Endpoints

POST   /api/paises
GET    /api/paises
GET    /api/paises/{id}
PUT    /api/paises/{id}
DELETE /api/paises/{id}

## Ordenação

GET /api/paises?sort=nome&direction=asc

GET /api/paises?sort=area&direction=desc