import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapParaListTest {

    @Test
    public void testAddElement() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");
        map.put(1, "B");

        MapParaList<Integer, String> listAdapter = new MapParaList<>(map);
        listAdapter.add("C");

        assertEquals(3, listAdapter.size());
        assertEquals("C", listAdapter.get(2));
    }

    @Test
    public void testGetElement() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "X");
        map.put(1, "Y");

        MapParaList<Integer, String> listAdapter = new MapParaList<>(map);

        assertEquals("X", listAdapter.get(0));
        assertEquals("Y", listAdapter.get(1));
    }

    @Test
    public void testRemoveElement() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "X");
        map.put(1, "Y");

        MapParaList<Integer, String> listAdapter = new MapParaList<>(map);
        listAdapter.remove(0);

        assertEquals(1, listAdapter.size());
        assertEquals("Y", listAdapter.get(0));
    }

    @Test
    public void testClearList() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "X");
        map.put(1, "Y");

        MapParaList<Integer, String> listAdapter = new MapParaList<>(map);
        listAdapter.clear();

        assertTrue(listAdapter.isEmpty());
    }
}
