# **Image service microservice**

## Description

This is a service that fetch the images from TheMovieDb and cache locally, also this service is capable of manipulation and transformation
of images. Supported operations are:

- resize
- convert to webp
- local caching jpg format

## Technologies Index

* Language
    * Java 11
* Framework
    - Spring Boot Web
* Spring Cloud tools
    - Config client
    - OpenFeign
    - Eureka(client) - service discovery
* Microservice communication
    - RESTFull
* Testing
    - Junit5
    - Mockito
* Documentation
    - Swagger
* Utility
    - Lombok
* Image processing
    - Thumbnailator
    - ImageIO
* Other tools
    - Gradle - dependencies management

## **Getting Started**

## Starting

There are 2 ways to start the service.

1) With Maven

```bash
mvn spring-boot:run
```

2) Using Docker In progress

[comment]: <> (## Usage)

[comment]: <> (```java)

[comment]: <> (```)

## API Reference

## Tests

## License

## Bugs

- ~~image not prefixed with type~~

[MIT](https://choosealicense.com/licenses/mit/)
