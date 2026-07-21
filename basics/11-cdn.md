# CDN (Content Delivery Network)

## What is a CDN?

A **CDN** is a network of geographically distributed servers (**edge servers**) that cache and deliver content from a location closer to the user, instead of every request hitting the origin server.

```
User (India) -----> Nearest Edge Server (Mumbai) -----> Cache Hit -> Response
                                |
                          Cache Miss
                                |
                          Origin Server
```

---

## Why Use a CDN?

- Reduces latency (content served from nearby edge location)
- Reduces load on origin server
- Improves availability during traffic spikes
- Protects against DDoS attacks
- Improves SEO (faster page loads)

---

## What Can Be Cached

- Static assets: images, CSS, JS, fonts
- Videos and streaming content
- HTML pages (for static sites)
- API responses (with proper cache headers)

Dynamic/personalized content is usually **not** cached, or cached briefly at the edge.

---

## Key Concepts

### 1. Edge Servers (PoPs)

Points of Presence — servers spread across regions/cities that store cached copies of content.

### 2. Origin Server

The actual source server. CDN pulls from here on a cache miss.

### 3. Cache Hit vs Cache Miss

- **Hit:** content served directly from edge server (fast)
- **Miss:** edge server fetches from origin, caches it, then serves it

### 4. TTL (Time To Live)

Defines how long content stays cached before the CDN re-validates with origin.

### 5. Push vs Pull CDN

- **Pull:** CDN fetches content from origin on first request (lazy)
- **Push:** Content is uploaded to CDN in advance

### 6. Cache Invalidation

Manually purging/expiring cached content when origin content changes before TTL expires.

---

## Popular CDN Providers

- Cloudflare
- Akamai
- Amazon CloudFront
- Fastly
- Google Cloud CDN

---

## Key Takeaway

A CDN reduces latency and origin load by serving cached content from servers closer to the user — a core building block for performance and availability at scale.
