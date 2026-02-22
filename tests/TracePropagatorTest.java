import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TracePropagatorTest {
    @Test void shouldProcessValid() {
        TracePropagator obj = new TracePropagator();
        assertNotNull(obj.process(Map.of("key", "val")));
    }
    @Test void shouldHandleNull() {
        TracePropagator obj = new TracePropagator();
        assertNull(obj.process(null));
    }
    @Test void shouldTrackStats() {
        TracePropagator obj = new TracePropagator();
        obj.process(Map.of("x", 1));
        assertEquals(1, obj.getStats().get("processed"));
    }
    @Test void supportShouldWork() {
        SpanContext obj = new SpanContext();
        assertNotNull(obj.process(Map.of("data", "test")));
    }
}
