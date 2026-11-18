# System Design Notes

A practical collection of revision notes and Java examples covering system design fundamentals, software design principles, and common design patterns.

## Repository Contents

- **[System Design Basics](basics/)** - Scalability, databases, caching, messaging, and distributed-system concepts
- **[Design Principles](design-principles/README.md)** - Java examples of SOLID, DRY, KISS, and YAGNI
- **[Design Patterns](design-patterns/README.md)** - Java implementations of creational design patterns
- **[Kubernetes](kubernetes/)** - Deployment strategies and rollout trade-offs

## System Design Basics

1. [Fundamentals](basics/01-fundamentals.md)
2. [Horizontal vs. Vertical Scaling](basics/02-horizontal-vs-vertical-scaling.md)
3. [CAP Theorem](basics/03-CAP-theorem.md)
4. [Load Balancing](basics/04-load-balancing.md)
5. [Consistent Hashing](basics/05-consistent-hashing.md)
6. [Message Queues](basics/06-message-queues.md)
7. [Microservice Architecture](basics/07-microservice-architecture.md)
8. [Database Partitioning and Sharding](basics/08-database-partitioning-n-sharding.md)
9. [Caching](basics/09-caching.md)
10. [Avoiding a Single Point of Failure](basics/10-avoid-single-point-of-failure.md)
11. [Content Delivery Networks](basics/11-cdn.md)
12. [Publisher-Subscriber Model](basics/12-publisher-subscriber-model.md)
13. [Event-Driven Systems](basics/13-event-driven-system.md)

## Design Principles

### SOLID

- [Single Responsibility Principle](design-principles/SOLID-principles/01-single-responsibility-principle.java)
- [Open/Closed Principle](design-principles/SOLID-principles/02-open-closed-principle.java)
- [Liskov Substitution Principle](design-principles/SOLID-principles/03-liskov-substitution-principle.java)
- [Interface Segregation Principle](design-principles/SOLID-principles/04-interface-segregation-principle.java)
- [Dependency Inversion Principle](design-principles/SOLID-principles/05-dependency-inversion-principle.java)

### Essential Principles

- [DRY](design-principles/DRY-principle/dry-principle.java)
- [KISS](design-principles/KiSS-principle/kiss-principle.java)
- [YAGNI](design-principles/YAGNI-principle/yagni-principle.java)

See the [design principles overview](design-principles/README.md) for explanations and usage guidance.

## Design Patterns

### Creational Patterns

- [Factory Pattern](design-patterns/CreationalDesignPatterns/01-FactoryPattern.java)
- [Abstract Factory Pattern](design-patterns/CreationalDesignPatterns/02-AbstractFactoryPattern.java)
- [Builder Pattern](design-patterns/CreationalDesignPatterns/03-BuilderPattern.java)
- [Singleton Pattern](design-patterns/CreationalDesignPatterns/04-SingletonPattern.java)
- [Prototype Pattern](design-patterns/CreationalDesignPatterns/05-PrototypePattern.java)

Structural and behavioral pattern examples are planned. See the [design patterns overview](design-patterns/README.md) for details.

## Kubernetes

- [Deployment Strategies](kubernetes/01-deployment-strategies.md) - Rolling updates, canary releases, blue-green deployments, and recreation

## Using These Notes

- Read the Markdown notes directly in GitHub or a Markdown viewer.
- Open the Java files with any Java-compatible editor or IDE.
- Compile an individual example with `javac` when it is self-contained.

## Contributing

Contributions are welcome. When adding a topic:

1. Follow the numbered naming convention used in the relevant directory.
2. Add the new note to this README.
3. Use relative links so files remain navigable on GitHub.
