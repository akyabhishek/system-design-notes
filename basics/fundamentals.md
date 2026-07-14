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
