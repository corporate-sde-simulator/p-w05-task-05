# PR Review - Distributed tracing context propagator (by Rohan)

## Reviewer: Kavitha Rajan
---

**Overall:** Good foundation but critical bugs need fixing before merge.

### `TracePropagator.java`

> **Bug #1:** Trace context injection adds headers but extraction reads from wrong header names
> This is the higher priority fix. Check the logic carefully and compare against the design doc.

### `SpanContext.java`

> **Bug #2:** Span parent-child relationship is inverted so child span ID is set as parent
> This is more subtle but will cause issues in production. Make sure to add a test case for this.

---

**Rohan**
> Acknowledged. I have documented the issues for whoever picks this up.
