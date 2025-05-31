import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ListParaMapTest {

    @Test
    public void testCriarEAdicionar() {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>();
        lista.add(new AbstractMap.SimpleEntry<>("a", 1));

        ListParaMap<String, Integer> adapter = new ListParaMap<>(lista);
        adapter.put("b", 2);

        assertEquals(2, adapter.size());
        assertEquals(1, adapter.get("a"));
        assertEquals(2, adapter.get("b"));
    }

    @Test
    public void testListaNula() {
        assertThrows(IllegalArgumentException.class, () -> new ListParaMap<String, Integer>(null));
    }
}
