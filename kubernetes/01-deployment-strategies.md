# Kubernetes Deployment Strategies

Deployment strategies describe how a new application version is introduced to users.

## Rolling Update

Gradually replaces old Pods with new Pods. Old and new versions may run at the same time.

```mermaid
flowchart LR
    U[Users] --> S[Service]
    S --> O[Old Pods]
    S --> N[New Pods]
    O -. gradually replaced .-> N
```

- **Advantages:** Usually avoids downtime; no full duplicate environment is needed.
- **Trade-offs:** Requires versions to coexist safely; rollout is not an instant switch.
- **Kubernetes:** The default Deployment strategy. `maxSurge` and `maxUnavailable` control the rollout pace.
- **Use when:** You want a straightforward release and the versions are compatible.

## Canary

Sends a small portion of production traffic to the new version, then increases it if health and metrics look good.

```mermaid
flowchart LR
    U[Users] --> R[Traffic router]
    R -->|Most traffic| O[Stable version]
    R -->|Small share| N[Canary version]
    N --> M[Check health and metrics]
    M -->|Healthy: increase share| R
    M -->|Unhealthy: stop or roll back| O
```

- **Advantages:** Limits user impact if the release has problems; validates against real traffic.
- **Trade-offs:** Needs traffic splitting and monitoring; rollout and rollback require more coordination.
- **Kubernetes:** Usually needs an ingress controller, service mesh, or progressive-delivery tool for traffic splitting.
- **Use when:** A change is risky and you want to validate it gradually.

## Blue-Green

Runs two environments: **blue** serves users while **green** hosts the candidate version. After validation, switch traffic to green; switch back to blue to roll back.

```mermaid
flowchart LR
    subgraph Before["1. Before switch"]
        U1[Users] --> S1[Service]
        S1 --> B1[Blue: v1 serving]
        G1[Green: v2 candidate] --> V[Validate green]
    end

    subgraph After["2. After switch"]
        U2[Users] --> S2[Service]
        S2 --> G2[Green: v2 serving]
        B2[Blue: v1 kept for rollback]
    end

    V -->|Healthy: change Service selector| S2
    S2 -. If needed, switch back .-> B2
```

- **Advantages:** Fast traffic switch and rollback.
- **Trade-offs:** Needs extra capacity; switching back does not undo database changes or other side effects.
- **Kubernetes:** Commonly implemented with separate Deployments and a Service whose selector is switched between versions.
- **Use when:** A quick cutover and rollback are important, and extra capacity is available.

## Quick Comparison

| Strategy | Traffic change | Main trade-off |
| --- | --- | --- |
| Rolling update | Gradual replacement | Old and new versions overlap |
| Canary | Gradual traffic increase | Needs traffic splitting and monitoring |
| Blue-green | Switch between environments | Needs capacity for both environments |

## Safe Rollouts

- Use readiness probes so traffic goes only to ready Pods.
- Monitor errors and latency; pause or roll back if they worsen.
- Keep APIs and database changes compatible with both versions during the rollout.