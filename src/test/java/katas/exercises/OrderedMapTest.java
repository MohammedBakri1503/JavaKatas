package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedMapTest {

    @Test
    void testPutAndGet() {
        OrderedMap<String, Integer> map = new OrderedMap<>();
        map.put("One", 1);
        map.put("Two", 2);

        assertEquals(1, map.get("One"), "Value for key 'One' should be 1");
        assertEquals(2, map.get("Two"), "Value for key 'Two' should be 2");
    }

    @Test
    void testKeysOrder() {
        OrderedMap<String, Integer> map = new OrderedMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        List<String> keys = map.keys();
        assertEquals(List.of("One", "Two", "Three"), keys, "Keys should be in insertion order");
    }

    @Test
    void testRemoveKey() {
        OrderedMap<String, Integer> map = new OrderedMap<>();
        map.put("One", 1);
        map.put("Two", 2);

        map.remove("One");
        assertNull(map.get("One"), "Key 'One' should be removed");
        assertEquals(1, map.size(), "Size should decrease after removal");
    }

    @Test
    void testUpdateValue() {
        OrderedMap<String, Integer> map = new OrderedMap<>();
        map.put("One", 1);
        map.put("One", 10);

        assertEquals(10, map.get("One"), "Value for key 'One' should be updated to 10");
        assertEquals(1, map.size(), "Size should not change when updating an existing key");
    }

    @Test
    void testSize() {
        OrderedMap<String, Integer> map = new OrderedMap<>();
        assertEquals(0, map.size(), "Size should be 0 initially");

        map.put("One", 1);
        map.put("Two", 2);
        assertEquals(2, map.size(), "Size should reflect the number of elements in the map");
    }

    @Test
    void testClear() {
        OrderedMap<String, Integer> map = new OrderedMap<>();
        map.put("One", 1);
        map.put("Two", 2);

        map.clear();
        assertEquals(0, map.size(), "Size should be 0 after clearing the map");
        assertTrue(map.keys().isEmpty(), "Keys list should be empty after clearing the map");
    }
}
