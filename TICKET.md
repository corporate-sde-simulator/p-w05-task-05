# PLATFORM-2921: Build distributed tracing context propagator

**Status:** In Progress · **Priority:** High
**Sprint:** Sprint 27 · **Story Points:** 5
**Reporter:** Priya Menon (Observability Lead) · **Assignee:** You (Intern)
**Due:** End of sprint (Friday)
**Labels:** `backend`, `java`, `observability`, `tracing`
**Task Type:** Feature Ship

---

## Description

We have a `SpanContext` class that stores trace and span IDs. We need a `TracePropagator` that can inject trace context into HTTP headers and extract it from incoming requests — essential for distributed tracing across microservices. Implement the TODO items in `TracePropagator.java`.

## Acceptance Criteria

- [ ] `inject()` serializes trace context into HTTP headers (traceparent format)
- [ ] `extract()` deserializes trace context from HTTP headers
- [ ] `startChildSpan()` creates a new span with the current span as parent
- [ ] W3C Trace Context format supported (traceparent header)
- [ ] Handles missing/malformed headers gracefully
- [ ] All unit tests pass
