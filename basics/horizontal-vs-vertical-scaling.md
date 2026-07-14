# Horizontal vs Vertical Scaling

## Visual

**Horizontal Scaling** — Add more machines

```
[1] [2] [3] [4] [5]
```

**Vertical Scaling** — Upgrade one machine

```
+----------------+
| Huge machine   |
+----------------+
```

---

## Distributed System vs Monolithic Architecture

| Property            | Distributed System      | Monolithic Architecture (M/A) |
| ------------------- | ----------------------- | ----------------------------- |
| (i) Fault Tolerance | Resilient               | Single point of failure       |
| (ii) Communication  | Network calls (RPC)     | Inter-process communication   |
| (iii) Data          | Data inconsistency      | Consistent                    |
| (iv) Scalability    | Scale as users increase | Hardware limit                |

---

## Horizontal vs Vertical — Comparison

| Property   | Horizontal Scaling         | Vertical Scaling        |
| ---------- | -------------------------- | ----------------------- |
| Cost       | Commodity hardware         | Expensive upgrades      |
| Complexity | High (distributed system)  | Low (single machine)    |
| Limit      | No hard limit              | Hardware ceiling        |
| Failure    | No single point of failure | Single point of failure |
| Downtime   | None                       | Required during upgrade |

---

## Real-World Examples

| System        | Strategy   | Reason                                      |
| ------------- | ---------- | ------------------------------------------- |
| Twitter       | Horizontal | Massive scale, millions of concurrent users |
| YouTube       | Horizontal | Video storage and global traffic            |
| Early Startup | Vertical   | Simple, fast, cost-effective to start       |
| PostgreSQL    | Vertical   | Single-node DB scales up before sharding    |

---

## When to Use

**Use Vertical when:**

- App is early-stage or low traffic
- Simplicity is more important than scale
- Quick fix needed without architectural changes

**Use Horizontal when:**

- Traffic is unpredictable or rapidly growing
- High availability and fault tolerance are required
- Vertical scaling has hit its limit
