# SportScape

SportScape is a modular backend microservices project for managing sports facilities, user accounts, and bookings. This system is architected with the Spring Boot and Spring Cloud stack, providing extensibility, robust service discovery, API gateway routing, and leveraging PostgreSQL for persistence.

## Features

- User registration, authentication, and management
- Facility and location management for sports venues
- Booking and payment handling
- API Gateway for secure, unified entrypoint and request routing
- Service discovery with Eureka
- Inter-service communication using OpenFeign
- PostgreSQL as the primary database and pgAdmin for database management

## System Architecture

The system is composed of the following independently deployable services:

| Service          | Description                                                                     |
| ---------------- | ------------------------------------------------------------------------------- |
| **apigw**        | API Gateway; routes client requests to corresponding backend services            |
| **booking-service** | Handles bookings, invoices, and payment-related operations                   |
| **facility-service** | Manages sports facilities, locations, and types                             |
| **user-service** | Provides user registration, authentication (JWT), and profile management        |
| **eureka-server**| Service discovery server for dynamic service registration and lookup            |
| **feign-clients**| Shared HTTP clients and DTOs for service-to-service communication               |

## Tech Stack

- Java 17
- Spring Boot 3.2.x
- Spring Cloud 2023.x (Eureka, OpenFeign)
- PostgreSQL (via Docker)
- pgAdmin (via Docker)
- Maven (multi-module build)
- Lombok

## Prerequisites

- [Java 17+](https://adoptopenjdk.net/)
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- [Docker & Docker Compose](https://docs.docker.com/get-docker/)

## Getting Started

1. **Clone the repository**
    ```bash
    git clone https://github.com/your-repo/sportscape.git
    cd sportscape
    ```

2. **Start the Database & pgAdmin**
    ```bash
    docker-compose up -d
    ```
    - PostgreSQL runs on port **5432**
    - pgAdmin is available at [http://localhost:5050](http://localhost:5050) (`admin@email.com` / `admin`)

3. **Build All Microservices**
    ```bash
    mvn clean install
    ```

4. **Run Each Service (in separate terminals for development)**
    - **Eureka Server:**
        ```bash
        cd eureka-server
        mvn spring-boot:run
        ```
        Eureka dashboard: [http://localhost:8761](http://localhost:8761)

    - **API Gateway:**
        ```bash
        cd apigw
        mvn spring-boot:run
        ```

    - **Other Services:**
        ```bash
        cd booking-service && mvn spring-boot:run
        cd facility-service && mvn spring-boot:run
        cd user-service && mvn spring-boot:run
        ```

    > *Note:* Service ports and DB configs can be adjusted in `src/main/resources/application.yml` of each service.

5. **Access the System**
    - Interact with the API via the API Gateway endpoint (default port/config found in `apigw`'s `application.yml`)
    - Service discovery handled automatically via Eureka

## Development

- All modules share a common parent `pom.xml` for dependency and plugin management.
- Inter-service calls use Feign clients from the `feign-clients` library.
- Modify environment settings (DB, ports, etc.) in `application.yml` under each service.

## License

Distributed under the MIT License. See `LICENSE` for more information.

---
