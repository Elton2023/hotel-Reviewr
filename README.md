# Hotel Reviewr

A microservices-based backend system that lets hotel owners get their hotels rated and reviewed by customers. Built with Spring Boot and Spring Cloud, demonstrating a real distributed-systems architecture: service discovery, centralized configuration, an API gateway, and inter-service communication.

> Status: work in progress. Core microservices architecture is functional; some features are still being built out.

## Architecture

This project is composed of 5 independent Spring Boot microservices:

| Service | Responsibility | Database |
|---------|------------------|----------|
| **serviceRegistry** | Eureka service discovery — lets services find each other | — |
| **ConfigServer** | Centralized configuration management (Spring Cloud Config) | — |
| **HotelGateWay** | API Gateway — single entry point routing requests to services (Spring Cloud Gateway) | — |
| **HotelService** | Manages hotel data | MySQL |
| **UserService** | Manages user data, communicates with other services via Feign | MySQL |
| **rating** | Manages hotel ratings/reviews | MongoDB |

Services register with Eureka on startup, pull their configuration from the Config Server, and communicate with each other through Feign clients — with the Gateway acting as the single public-facing entry point.

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot, Spring Cloud
- **Service Discovery:** Netflix Eureka
- **Configuration:** Spring Cloud Config Server (config sourced from a separate repo: [micro-configuration-servicez](https://github.com/Elton2023/micro-configuration-servicez))
- **API Gateway:** Spring Cloud Gateway (WebFlux-based)
- **Inter-service communication:** OpenFeign
- **Databases:** MySQL (Hotel/User services), MongoDB (Rating service) — polyglot persistence
- **Build Tool:** Maven

## Getting Started

### Prerequisites

- Java JDK
- Maven
- MySQL and MongoDB running locally or accessible remotely
- Each microservice needs its own database set up per its configuration

### Startup Order

Microservices must be started in this order so each can register and pull config correctly:

1. **serviceRegistry** (Eureka server)
2. **ConfigServer**
3. **HotelGateWay** (API Gateway)
4. **HotelService**, **UserService**, **rating** (can start in any order once the above are running)

For each service:
```bash
cd HotelReview/<service-name>
./mvnw spring-boot:run
```

## What I Learned Building This

This project was built to get hands-on with microservices architecture beyond a single monolithic app — including service discovery with Eureka, centralized externalized configuration with Spring Cloud Config, routing through an API Gateway, synchronous inter-service communication with Feign, and working with two different databases (MySQL and MongoDB) across services in the same system.

## Future Improvements

- [ ] Add authentication/authorization across the gateway
- [ ] Add centralized logging/tracing (e.g. Sleuth/Zipkin) for observability across services
- [ ] Containerize each service with Docker and add docker-compose for one-command startup
- [ ] Add circuit breaker / resilience patterns (e.g. Resilience4j) for inter-service calls
- [ ] Complete remaining in-progress features

## License

MIT (or update to whatever you prefer)
