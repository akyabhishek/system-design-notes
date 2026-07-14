# System design Fundamentals

## Vertical Scaling

Also known as **Scale Up**.

Optimize the process and increase the throughput with the **same resource**.

> **e.g.** Paying more to a chef to handle more customers.

**Pros**

- Simple - no distributed system complexity
- No code changes required

**Cons**

- Hard hardware limit (ceiling) — can't scale forever
- Single point of failure
- Requires downtime during upgrade

**When to Use**

- Early-stage applications
- When horizontal scaling complexity isn't justified yet

## Preprocessing

Pre-computing and preparing data during non-peak hours (via cron jobs) so requests during peak hours are served instantly without heavy computation.

## Resilience

The ability to recover from failures quickly by keeping backups, avoiding single points of failure, and implementing redundancy.

## Horizontal Scaling

Also known as **Scale Out**.

Add **more machines** of the same type to distribute the load.

> **e.g.** Hiring more chefs instead of paying one chef more.

**Pros**

- No hard limit — can scale indefinitely
- No single point of failure
- No downtime required

**Cons**

- More complex — requires load balancing, distributed coordination
- Code may need changes (stateless design, etc.)

**When to Use**

- High-traffic, large-scale systems
- When vertical scaling has hit its limit

## Microservices

An independently deployable unit of an application that owns a single business capability and communicates with other services via APIs or messaging.

## Distributed System

A collection of **independent computers** that appear to users as a **single coherent system** by coordinating over a network.

## Load Balancer

A **proxy** that distributes incoming traffic across multiple servers to ensure no single instance is overwhelmed.

## Decoupling

Designing components so they **don't depend on each other**, allowing them to change independently without breaking the system.

## Logging

Records discrete events (errors, requests, state changes) as **timestamped text** for debugging and auditing.

## Metrics

**Numerical measurements** collected over time (CPU%, request rate, latency) for monitoring system health and performance.

## Extensible

Designed so **new functionality can be added without modifying existing code**.

---

## Caching

Storing **frequently accessed data in fast memory** (e.g., Redis) to reduce latency and offload the database.

> **e.g.** Storing a user's profile in Redis so every request doesn't hit the DB.

**When to Use**

- Read-heavy workloads
- Data that doesn't change frequently
- Reducing repeated expensive computations or DB queries

---

## Latency vs Throughput

| Property   | Definition                                      | Example                    |
| ---------- | ----------------------------------------------- | -------------------------- |
| Latency    | Time taken to process **one request**           | 200ms to load a page       |
| Throughput | Number of requests handled **per unit of time** | 10,000 requests per second |

> Low latency + high throughput = ideal system.

---

## Fault Tolerance

The ability of a system to **continue operating correctly** even when some components fail.

> Different from Resilience — Fault Tolerance is about **preventing disruption**, Resilience is about **recovering from it**.

**Techniques**

- Redundancy
- Replication
- Failover mechanisms

---

## CDN (Content Delivery Network)

A network of **geographically distributed servers** that serve static content (images, JS, CSS, videos) from locations closest to the user.

> **e.g.** A user in India getting assets from a Mumbai edge server instead of a US origin server.

**Benefits**

- Reduced latency
- Lower load on origin server
- Better availability

---

## Message Queue

An **async communication** mechanism where producers send messages to a queue and consumers process them independently.

> **e.g.** Kafka, RabbitMQ, Amazon SQS

**Benefits**

- Decouples services
- Handles traffic spikes (acts as a buffer)
- Enables retry on failure

---

## Database — SQL vs NoSQL

| Property    | SQL (Relational)         | NoSQL                        |
| ----------- | ------------------------ | ---------------------------- |
| Structure   | Tables with fixed schema | Flexible schema (JSON, etc.) |
| Scaling     | Vertical                 | Horizontal                   |
| Consistency | Strong                   | Eventual (usually)           |
| Use Case    | Banking, ERP             | Social media, real-time apps |
| Examples    | PostgreSQL, MySQL        | MongoDB, Cassandra, DynamoDB |

---

## Rate Limiting

Controlling the **number of requests** a client can make within a given time window to protect the system from abuse or overload.

> **e.g.** Max 100 API requests per minute per user.

**Algorithms**

- Token Bucket
- Sliding Window
- Fixed Window Counter
