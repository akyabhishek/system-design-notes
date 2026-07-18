# Microservice Architecture (Revision Notes)

## Definition

Microservice Architecture is an architectural style where an application
is divided into **small, independent, loosely coupled services**.

Each service: - Has a single responsibility - Can be developed,
deployed, and scaled independently - Communicates with other services
using APIs or messaging

```text
        Client
           |
      API Gateway
     /     |      \
 User  Product  Order
  MS      MS      MS
    \      |      /
      Database per Service
```

---

# Monolith vs Microservices

| Monolith           | Microservices             |
| ------------------ | ------------------------- |
| Single application | Multiple small services   |
| Single deployment  | Independent deployments   |
| Shared database    | Database per service      |
| Hard to scale      | Scale individual services |
| Tightly coupled    | Loosely coupled           |

---

# Characteristics

- Single Responsibility
- Independent Deployment
- Loose Coupling
- High Cohesion
- Fault Isolation
- Technology Independent
- Database per Service

---

# Components

## API Gateway

- Single entry point
- Authentication
- Rate limiting
- Routing
- Load balancing

## Service Discovery

Helps services find each other dynamically.

Examples: - Eureka - Consul - Kubernetes DNS

## Configuration Server

Stores centralized configuration.

Example: - Spring Cloud Config

## Database per Service

Each microservice owns its own database.

---

# Communication

## Synchronous

- REST API
- gRPC

Pros: - Simple - Immediate response

Cons: - Tightly dependent - Higher latency

## Asynchronous

Uses message brokers.

Examples: - Kafka - RabbitMQ

Pros: - Loose coupling - Better scalability - Fault tolerant

---

# Data Management

- Database per service
- No shared database
- Event-driven consistency
- Saga Pattern for distributed transactions

---

# Scaling

Horizontal Scaling

```text
Order Service

Order-1
Order-2
Order-3
```

Scale only the service under heavy load.

---

# Fault Tolerance

Techniques: - Circuit Breaker - Retry - Timeout - Fallback - Bulkhead

---

# Advantages

- Independent deployment
- Faster development
- Easy scaling
- Better fault isolation
- Team autonomy
- Technology flexibility

---

# Disadvantages

- Complex architecture
- Distributed debugging
- Network latency
- Data consistency challenges
- Monitoring complexity

---

# Common Patterns

- API Gateway
- Service Discovery
- Circuit Breaker
- Saga Pattern
- CQRS
- Event Sourcing
- Strangler Pattern

---

# Common Tools

- Spring Boot
- Spring Cloud
- Docker
- Kubernetes
- Kafka
- RabbitMQ
- Eureka
- Prometheus
- Grafana
- Zipkin

---

# Interview Questions

- What are microservices?
- Monolith vs Microservices?
- Why database per service?
- REST vs Messaging?
- What is API Gateway?
- What is Service Discovery?
- Explain Circuit Breaker.
- Explain Saga Pattern.
- How do microservices communicate?
- How do you achieve fault tolerance?

---

# One-Line Revision

- **Microservice:** Small independent service.
- **API Gateway:** Single entry point.
- **Service Discovery:** Finds service instances.
- **Database per Service:** No shared database.
- **REST:** Synchronous communication.
- **Kafka/RabbitMQ:** Asynchronous communication.
- **Circuit Breaker:** Prevents cascading failures.
- **Saga:** Manages distributed transactions.
- **Horizontal Scaling:** Scale only required services.
- **Loose Coupling:** Services are independent.
