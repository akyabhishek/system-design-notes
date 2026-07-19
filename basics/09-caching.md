# System Design Revision Notes -- Caching

## 1. Why Caching?

-   Reduces latency
-   Reduces database load
-   Improves throughput
-   Handles traffic spikes

------------------------------------------------------------------------

## 2. Cache Flow

### Cache Hit

    Client -> App -> Cache -> Return Data

### Cache Miss

    Client -> App -> Cache (Miss)
                      |
                      v
                  Database
                      |
                 Update Cache
                      |
                 Return Data

------------------------------------------------------------------------

## 3. Types of Cache

### Browser Cache

-   CSS
-   JS
-   Images

### CDN Cache

-   Static assets
-   Images
-   Videos
-   Thumbnails

### Application (Local) Cache

-   Stored inside application memory (JVM)
-   Examples:
    -   HashMap
    -   ConcurrentHashMap
    -   Caffeine
-   Fastest
-   Not shared across servers

### Global Cache

-   Shared by all application instances
-   Usually Redis or Memcached
-   One logical cache for entire application

```{=html}
<!-- -->
```
    App1
     \
      \
       Redis
      /
     /
    App2

### Distributed Cache

-   Cache spread across multiple cache nodes
-   Data partitioned using hashing (e.g. consistent hashing)
-   Scales horizontally

```{=html}
<!-- -->
```
    Redis Cluster

    Node1
    Node2
    Node3

------------------------------------------------------------------------

## 4. Local vs Global vs Distributed

  Feature          Local     Global      Distributed
  ---------------- --------- ----------- -------------
  Shared           ❌        ✅          ✅
  Speed            Fastest   Very Fast   Very Fast
  Network Call     No        Yes         Yes
  Scalable         ❌        Limited     ✅
  Duplicate Data   Yes       No          No

------------------------------------------------------------------------

## 5. Cache Patterns

### Cache Aside (Lazy Loading) ⭐ Most Common

1.  Check Cache
2.  Cache Hit → Return
3.  Cache Miss → Read DB
4.  Store in Cache
5.  Return

Pros: - Easy - Only frequently used data cached

Cons: - First request is slower

------------------------------------------------------------------------

### Read Through

Application -\> Cache -\> Database

Cache fetches missing data automatically.

------------------------------------------------------------------------

### Write Through

Application ↓ Cache ↓ Database

-   Cache and DB updated together
-   Strong consistency
-   Higher write latency

------------------------------------------------------------------------

### Write Back (Write Behind)

Application ↓ Cache ↓ Return Success ↓ Database updated later

-   Fast writes
-   Eventual consistency
-   Risk of data loss if cache fails

------------------------------------------------------------------------

### Write Around

Application ↓ Database

Cache populated only when data is read later.

------------------------------------------------------------------------

## 6. TTL (Time To Live)

-   Expiration time for cache entries
-   Prevents stale data

Example:

    EXPIRE user:101 300

------------------------------------------------------------------------

## 7. Cache Eviction

### LRU

Least Recently Used

### LFU

Least Frequently Used

### FIFO

First In First Out

### Random

Random eviction

------------------------------------------------------------------------

## 8. Cache Invalidation

Update DB → Cache becomes stale

Solutions: - Delete cache after update - Update cache immediately -
TTL - Event-driven invalidation (Kafka/RabbitMQ)

------------------------------------------------------------------------

## 9. Common Problems

### Cache Stampede

Many requests after expiration.

Solutions: - Distributed lock - Request coalescing - Random TTL -
Background refresh

### Cache Penetration

Requests for non-existing keys.

Solutions: - Cache null values - Bloom Filter

### Cache Avalanche

Many keys expire together.

Solutions: - Randomized TTL - Warm-up cache

### Hot Keys

One key gets huge traffic.

Solutions: - Replication - Sharding - Rate limiting

------------------------------------------------------------------------

## 10. Redis Commands

``` bash
SET key value
GET key
DEL key
EXPIRE key 300
```

Time Complexity: - GET → O(1) - SET → O(1) - DEL → O(1)

------------------------------------------------------------------------

## 11. What to Cache?

✅ User profiles

✅ Product details

✅ Sessions

✅ API responses

✅ Configuration

✅ Search results

❌ Frequently changing data (unless short TTL)

❌ Sensitive data without proper security

------------------------------------------------------------------------

## 12. Interview Answers

### Why Redis?

-   In-memory
-   O(1) operations
-   Extremely low latency
-   Supports TTL
-   Rich data structures
-   Horizontal scaling

### Most Common Pattern

**Cache Aside + Redis**

### Difference Between Global and Distributed Cache

-   Global Cache: Shared cache used by all applications.
-   Distributed Cache: Cache itself is partitioned across multiple cache
    servers.

> In practice, a Redis Cluster is both **global (shared)** and
> **distributed (partitioned)**.

------------------------------------------------------------------------

## 13. Quick Revision (30 Seconds)

-   Cache = Faster storage layer
-   Cache Hit = Data found
-   Cache Miss = Read DB + Update Cache
-   Local Cache = Inside app
-   Global Cache = Shared Redis
-   Distributed Cache = Redis Cluster
-   Cache Aside = Most common
-   TTL = Expiration
-   LRU = Most popular eviction
-   Redis = O(1) GET/SET
-   Watch for Stampede, Penetration, Avalanche, Hot Keys
