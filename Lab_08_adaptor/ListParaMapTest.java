import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ListParaMapTest {

    @Test
    public void testPutAndGet() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        entryList.add(new AbstractMap.SimpleEntry<>("um", 1));

        ListParaMap<String, Integer> mapAdapter = new ListParaMap<>(entryList);
        mapAdapter.put("dois", 2);

        assertEquals(2, mapAdapter.size());
        assertEquals(1, mapAdapter.get("um"));
        assertEquals(2, mapAdapter.get("dois"));
    }

    @Test
    public void testRemove() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        entryList.add(new AbstractMap.SimpleEntry<>("a", 10));
        entryList.add(new AbstractMap.SimpleEntry<>("b", 20));

        ListParaMap<String, Integer> mapAdapter = new ListParaMap<>(entryList);
        Integer removed = mapAdapter.remove("a");

        assertEquals(10, removed);
        assertFalse(mapAdapter.containsKey("a"));
        assertEquals(1, mapAdapter.size());
    }

    @Test
    public void testClear() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        entryList.add(new AbstractMap.SimpleEntry<>("x", 5));
        entryList.add(new AbstractMap.SimpleEntry<>("y", 6));

        ListParaMap<String, Integer> mapAdapter = new ListParaMap<>(entryList);
        mapAdapter.clear();

        assertTrue(mapAdapter.isEmpty());
    }

    @Test
    public void testContainsKeyAndValue() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        entryList.add(new AbstractMap.SimpleEntry<>("key", 100));

        ListParaMap<String, Integer> mapAdapter = new ListParaMap<>(entryList);

        assertTrue(mapAdapter.containsKey("key"));
        assertTrue(mapAdapter.containsValue(100));
    }
}
