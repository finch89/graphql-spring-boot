# GraphQL Java Spring Boot Application

This project is an adaptation of the NodeJS graphql-in-action project.

### Technology Stack
* Java 11
* Spring Boot 2.5.6
* Spring 5.3.12

### Persistence Layer
* PostgreSQL
* MongoDB

## Run the application
From the project root folder, execute:

`./mvnw spring-boot:run`

The application is configured to be running on port _4322_.

## Quick Test the application
The GraphQL API endpoint is currently configured as `/graphql`.
The following GraphQL query can be executed:

```
query {
  test
}
```

The expected result should be:

```
{
  "data": {
    "test": "response"
  }
}
```