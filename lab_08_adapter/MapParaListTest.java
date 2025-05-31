import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapParaListTest {

    @Test
    public void testAddEGet() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");
        map.put(1, "B");

        MapParaList<Integer, String> adapter = new MapParaList<>(map);
        adapter.add("C");

        assertEquals("A", adapter.get(0));
        assertEquals("B", adapter.get(1));
        assertEquals("C", adapter.get(2));
        assertEquals(3, adapter.size());
    }

    @Test
    public void testIndiceInvalido() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "X");

        MapParaList<Integer, String> adapter = new MapParaList<>(map);
        assertThrows(IndexOutOfBoundsException.class, () -> adapter.get(5));
    }
}
