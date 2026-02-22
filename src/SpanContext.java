/**
 * SpanContext — stores trace and span identification.
 * 
 * This module is COMPLETE and WORKING. Do NOT modify.
 * Your task is to implement TracePropagator.java.
 * 
 * Author: Kiran Desai (Platform team)
 * Last Modified: 2026-03-05
 */

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class SpanContext {
    private final String traceId;      // 32-char hex (128-bit)
    private final String spanId;       // 16-char hex (64-bit)
    private final String parentSpanId; // null for root span
    private final boolean sampled;     // Whether this trace is being recorded
    private final Map<String, String> baggage; // Propagated key-value pairs
    private final long startTimeMs;

    public SpanContext(String traceId, String spanId, String parentSpanId, boolean sampled) {
        this.traceId = traceId;
        this.spanId = spanId;
        this.parentSpanId = parentSpanId;
        this.sampled = sampled;
        this.baggage = new HashMap<>();
        this.startTimeMs = System.currentTimeMillis();
    }

    public static SpanContext createRoot() {
        String traceId = generateTraceId();
        String spanId = generateSpanId();
        return new SpanContext(traceId, spanId, null, true);
    }

    public static SpanContext createChild(SpanContext parent) {
        String spanId = generateSpanId();
        SpanContext child = new SpanContext(parent.traceId, spanId, parent.spanId, parent.sampled);
        child.baggage.putAll(parent.baggage);
        return child;
    }

    private static String generateTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String generateSpanId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    public void setBaggage(String key, String value) { baggage.put(key, value); }
    public String getBaggage(String key) { return baggage.get(key); }
    public Map<String, String> getAllBaggage() { return new HashMap<>(baggage); }
    public String getTraceId() { return traceId; }
    public String getSpanId() { return spanId; }
    public String getParentSpanId() { return parentSpanId; }
    public boolean isSampled() { return sampled; }
    public long getStartTimeMs() { return startTimeMs; }
    public long getDurationMs() { return System.currentTimeMillis() - startTimeMs; }

    @Override
    public String toString() {
        return String.format("SpanContext{traceId=%s, spanId=%s, parent=%s, sampled=%s}",
            traceId, spanId, parentSpanId, sampled);
    }
}
