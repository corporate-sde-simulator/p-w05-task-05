/**
 * TracePropagator — injects/extracts trace context across service boundaries.
 * 
 * YOU MUST IMPLEMENT the methods marked with TODO below.
 * SpanContext.java is working — you use it to build and parse trace headers.
 * 
 * W3C Trace Context format (traceparent header):
 *   "00-{traceId}-{spanId}-{flags}"
 *   Example: "00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01"
 *   flags: "01" = sampled, "00" = not sampled
 */

import java.util.Map;
import java.util.HashMap;

public class TracePropagator {

    private static final String TRACEPARENT_HEADER = "traceparent";
    private static final String TRACESTATE_HEADER = "tracestate";
    private static final String VERSION = "00";

    /**
     * Inject trace context into HTTP headers for outgoing requests.
     *
     * TODO: Implement this method.
     * 1. Build the traceparent header value: "00-{traceId}-{spanId}-{flags}"
     * 2. flags = "01" if sampled, "00" if not
     * 3. Put the traceparent header into the headers map
     * 4. Also inject any baggage items as "baggage-{key}" headers
     * 5. Return the headers map
     */
    public Map<String, String> inject(SpanContext context, Map<String, String> headers) {
        // TODO: Build and inject traceparent header
        // TODO: Inject baggage items as individual headers
        return headers;
    }

    /**
     * Extract trace context from incoming HTTP request headers.
     *
     * TODO: Implement this method.
     * 1. Get the traceparent header value
     * 2. Parse it: split by "-" to get [version, traceId, spanId, flags]
     * 3. Validate: version must be "00", traceId 32 chars, spanId 16 chars
     * 4. Create a SpanContext with the parsed values
     * 5. Extract any "baggage-*" headers and set them on the context
     * 6. Return null if header is missing or malformed
     */
    public SpanContext extract(Map<String, String> headers) {
        // TODO: Parse traceparent header and create SpanContext
        return null;
    }

    /**
     * Start a child span from an existing context.
     *
     * TODO: Implement this method.
     * 1. Use SpanContext.createChild(parentContext) to create a new child span
     * 2. Return the child context
     * 3. Return a new root span if parentContext is null
     */
    public SpanContext startChildSpan(SpanContext parentContext) {
        // TODO: Create child span or root span
        return null;
    }

    /**
     * Validate a traceparent header string.
     *
     * TODO: Implement this method.
     * 1. Check format: exactly 4 parts separated by "-"
     * 2. Version must be "00"
     * 3. TraceId must be 32 hex characters (not all zeros)
     * 4. SpanId must be 16 hex characters (not all zeros)
     * 5. Flags must be 2 hex characters
     * 6. Return true only if all validations pass
     */
    public boolean isValidTraceparent(String header) {
        // TODO: Validate traceparent format
        return false;
    }
}
