# CAP Theorem

## Definition

> **CAP Theorem** states that a **distributed system** can guarantee **at most two out of three** properties — **Consistency (C)**, **Availability (A)**, and **Partition Tolerance (P)** — simultaneously.
>
> In practice, since **Partition Tolerance is mandatory** in real distributed systems, the real trade-off is: when a **Network Partition** occurs, the system must choose **either Consistency or Availability, but not both simultaneously.**

**Remember:** In real distributed systems, **Partition Tolerance is mandatory**.

---

## CAP

### C → Consistency

- Every client sees the **latest committed data**.
- All replicas contain the same data.
- Prioritizes **correctness**.
- May reject requests during failures.

**Examples**

- Banking
- Stock Trading
- Payment Systems
- Inventory Management

---

### A → Availability

- Every request receives a response.
- Response may contain **stale data**.
- Prioritizes **uptime**.

**Examples**

- Instagram
- Facebook
- WhatsApp
- Twitter/X

---

### P → Partition Tolerance

- System continues operating despite **network failures** between nodes.
- Network partitions are **inevitable** in distributed systems.

**Causes**

- Router failure
- Cable damage
- Cloud region outage
- Firewall issue
- Switch failure

---

## CAP Decision

During a **Network Partition**:

### Option 1 → Availability

- Return a response immediately.
- Data may be outdated.

### Option 2 → Consistency

- Reject the request until data is synchronized.
- Data is always correct.

---

## CP System

**Consistency + Partition Tolerance**

**Characteristics**

- Correct data
- May reject requests
- Lower availability during partitions

**Examples**

- Apache ZooKeeper
- Apache HBase
- etcd

**Used In**

- Banking
- Financial Systems
- Distributed Locks
- Hospital Systems

---

## AP System

**Availability + Partition Tolerance**

**Characteristics**

- Always responds
- May return stale data
- Uses eventual consistency

**Examples**

- Apache Cassandra
- CouchDB
- Amazon DynamoDB (configurable)

**Used In**

- Social Media
- Chat Applications
- Recommendation Systems
- DNS

---

## CA System

**Consistency + Availability**

Possible **only when there is no network partition**.

Example:

- Single MySQL Database
- Single PostgreSQL Database

---

## Strong Consistency

- Every read returns the **latest write**.
- No stale data.

**Example**

- Banking

---

## Eventual Consistency

- Data becomes consistent **after some time**.
- Temporary stale reads are acceptable.

**Examples**

- Instagram
- Facebook
- WhatsApp

---

## Comparison

| Property            | Meaning                          |
| ------------------- | -------------------------------- |
| Consistency         | Latest data is always returned   |
| Availability        | Every request gets a response    |
| Partition Tolerance | System survives network failures |

---

## Strong vs Eventual Consistency

| Strong Consistency | Eventual Consistency  |
| ------------------ | --------------------- |
| Latest data always | May return stale data |
| Higher correctness | Higher availability   |
| Banking            | Social Media          |

---

## Interview Points

### What is CAP?

A distributed system can guarantee **either Consistency or Availability** when a **Network Partition** occurs.

### Why not all three?

Because during a partition, nodes cannot communicate. The system must choose between:

- Correct data (Consistency)
- Always responding (Availability)

### Is Partition Tolerance optional?

**No.** In distributed systems, partitions are unavoidable.

### Banking chooses?

**CP**

### Instagram chooses?

**AP**

### Does CAP apply to a single MySQL database?

**No.** CAP applies to distributed systems.

---

# One-Line Revision

**CAP = During a Network Partition, choose either Correct Data (Consistency) or Always Respond (Availability).**
