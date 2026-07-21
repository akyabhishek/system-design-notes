# Publisher-Subscriber (Pub/Sub) Model

## Problem Statement

In a system where services need to communicate, direct (synchronous) calls between them create **tight coupling**:

```
Service A ---> Service B
          ---> Service C
          ---> Service D
```

Problems with this approach:

- Service A must know about every consumer (B, C, D) directly
- If a new consumer is added, Service A's code must change
- If any consumer is slow/down, it can block or fail Service A
- Scaling consumers independently becomes hard

**Pub/Sub solves this** by introducing a broker between producers and consumers, so services don't need to know about each other — they only need to know about the topic.

## What is Pub/Sub?

A messaging pattern where **publishers** send messages without knowing who will receive them, and **subscribers** receive messages without knowing who sent them. A **broker/message queue** sits in between and decouples the two.

```
Publisher -----> Topic/Broker -----> Subscriber 1
                              -----> Subscriber 2
                              -----> Subscriber 3
```

---

## Key Concepts

### 1. Publisher

Produces/sends messages to a topic. Doesn't know or care who consumes them.

### 2. Subscriber

Consumes messages from a topic it has subscribed to.

### 3. Topic / Channel

A named category messages are published to. Subscribers subscribe to specific topics.

### 4. Broker

The middleman (Kafka, RabbitMQ, Redis Pub/Sub, SNS/SQS) that routes messages from publishers to subscribers.

### 5. Decoupling

Publisher and subscriber are independent — neither needs to know the other's identity, location, or availability.

---

## Pub/Sub vs Point-to-Point (Queue)

| Pub/Sub                        | Point-to-Point (Queue)                          |
| ------------------------------ | ----------------------------------------------- |
| One message → many subscribers | One message → one consumer                      |
| Broadcast style                | Work distribution style                         |
| Subscribers get their own copy | Message removed after one consumer processes it |

---

## Delivery Semantics

- **At-most-once** – message may be lost, never duplicated
- **At-least-once** – message guaranteed delivered, may be duplicated (needs idempotent consumers)
- **Exactly-once** – hardest to achieve, needs dedup + transactional guarantees

---

## Common Patterns

- **Fan-out** – one publisher, multiple subscribers each get full copy (e.g., SNS → multiple SQS queues)
- **Topic-based filtering** – subscribers only get messages matching a topic/subject
- **Content-based filtering** – subscribers filter based on message content/attributes
- **Dead Letter Queue (DLQ)** – failed/unprocessable messages routed here instead of being lost

---

## Benefits

- Loose coupling between services
- Better scalability (add subscribers without touching publisher)
- Asynchronous processing
- Improved fault tolerance (broker buffers messages if subscriber is down)

## Challenges

- Message ordering isn't guaranteed by default (depends on system)
- Duplicate message handling (idempotency needed)
- Debugging/tracing is harder (indirect communication)
- Broker becomes a critical component — needs to be highly available

---

## Popular Tools

- Apache Kafka
- RabbitMQ
- Redis Pub/Sub
- AWS SNS + SQS
- Google Cloud Pub/Sub
- NATS

---

## Key Takeaway

Pub/Sub decouples producers from consumers via a broker, enabling asynchronous, scalable, one-to-many communication — a core pattern for event-driven architectures.
