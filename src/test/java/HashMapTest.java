import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    private HashMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
    }

    @Test
    void testPut() {
        map.put("key1", "value1");
        assertEquals("value1", map.get("key1"));
    }

    @Test
    void testPutWithExistingKey() {
        map.put("key1", "value1");
        map.put("key1", "newValue");
        assertEquals("newValue", map.get("key1"));
    }

    @Test
    void testRemove() {
        map.put("key1", "value1");
        assertTrue(map.remove("key1") != null);
        assertNull(map.get("key1"));
    }

    @Test
    void testGetWithNonExistentKey() {
        assertNull(map.get("nonExistentKey"));
    }
}