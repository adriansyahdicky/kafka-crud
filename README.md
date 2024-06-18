# Spring Boot Kafka CRUD with Flyway

This project demonstrates a Spring Boot application that provides CRUD operations for managing employees. It integrates Kafka for messaging and Flyway for database migrations.

## Prerequisites

- JDK 21 or higher
- Maven 3.6.0 or higher
- Docker (for running Kafka)
- PostgreSQL (configured for Flyway)

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/adriansyahdicky/kafka-crud.git
cd spring-boot-kafka-crud

## API Endpoints

### Retrieve all employees
- **GET /api/v1/employees**

  Retrieves a list of all employees.

  Example:


### Create a new employee
- **POST /api/v1/employees**

Creates a new employee.

Example Request Body:
```json

POST http://localhost:8282/api/v1/employees
Content-Type: application/json
Body:
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}

PUT http://localhost:8282/api/v1/employees/1
Content-Type: application/json
Body:
{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com"
}

DELETE http://localhost:8282/api/v1/employees/1

