# **Movie microservice application**

## Description

## Build status

## Code style

## Repository Structure

- **Core**
    - Domain
- **Internal**
    - Config service
    - Discovery service
    - Gateway
- **Services**
    - **Email-service**
    - **Image-service**
    - **Movie-service**
    - **Recommendation-service**
    - **Statistics-service**
    - **Suggestion-service**
    - **Users-service**
- **Utils**
    - authentification
    - communication
    - data-loader
    - tenants

---

## Technologies Index

* Language
    * Java 15 , Groovy (testing)
* Base Framework
    - Spring Boot
* Spring Cloud tools
    - ~~AWS~~
    - Config
    - Vault
    - ~~Pipelines~~
    - Eureka(client/server) - service discovery
    - Spring Gateway
* Databases
    - Spring Data Neo4j with Liquigraph - recommendations database
    - Spring Data Redis - cache and statistics
    - Spring Data Jpa with Flyway(Postgres)
    - Spring Data Mongo with QueryDsl - user management and movie details
    - Spring Data Elasticsearch - advanced search capabilities
* Security management
    - Spring Security
* Microservice communication
    - RabbitMQ - message broker
    - RESFull
* Testing
    - Junit5
    - Mockito
    - Spock
* Documentation
    - Swagger and [Stoplight](https://stoplight.io/)
* Utility
    - Lombok
    - ModelMapper - mapper
    - MapStruct - mapper
* Other tools
    - Gradle - dependencies management
    - OpenFeign

## Communications between microservices

Communication between services is done using different method:

- RESTFull
- Messages(to be implemented)

## **Getting Started**

## Installation

To download all dependencies needed for the project and to build the project you need to run:

```bash
./gradlew build
```

## Usage

To start a service from cli you need to run:

```bash
./gradlew name-service:bootRun
```

Where **name-service** is the location of service; Example

```bash
./gradlew sercices:movie-service:bootRun
```

## API Reference

## Tests

## License

[MIT](https://choosealicense.com/licenses/mit/)

## Status
