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
cd kafka-crud

# Setup Kafka using Docker

This guide will walk you through setting up Kafka using Docker.

## Prerequisites

- Docker installed on your machine. If not installed, download and install Docker from [Docker's official website](https://www.docker.com/get-started).

## Steps

### 1. Create Docker Compose File

Create a `docker-compose.yml` file in your project directory and add the following content:

```yaml
version: '3.8'

services:
  rabbitmq:
    image: rabbitmq:3.9.12-management
    container_name: rabbitmq
    ports:
      - "5672:5672"   # RabbitMQ main port
      - "15672:15672" # RabbitMQ management UI port
    environment:
      RABBITMQ_DEFAULT_USER: guest
      RABBITMQ_DEFAULT_PASS: guest

# Employee Management API

API ini digunakan untuk mengelola data karyawan.

## Endpoint

Base URL: `http://localhost:8282/api/v1/employees`

## Daftar Operasi CRUD

### 1. Retrieve all employees

- **Method**: GET
- **Endpoint**: `/`
- **Deskripsi**: Mendapatkan daftar semua karyawan yang tersimpan.

#### Contoh Permintaan:
```http
GET http://localhost:8282/api/v1/employees

POST http://localhost:8282/api/v1/employees
Content-Type: application/json

{
  "name": "John",
  "mobilePhone": "08787182718",
  "address": "jakarta"
}

PUT http://localhost:8282/api/v1/employees/172810-0201930-102019
Content-Type: application/json

{
  "name": "John",
  "mobilePhone": "08787182718",
  "address": "jakarta"
}

DELETE http://localhost:8282/api/v1/employees/172810-0201930-102019



