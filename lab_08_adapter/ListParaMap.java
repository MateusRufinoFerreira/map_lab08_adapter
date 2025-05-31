import java.util.*;

public class ListParaMap<K, V> extends AbstractMap<K, V> {
    private final Map<K, V> mapaInterno;

    public ListParaMap(List<Entry<K, V>> entradas) {
        if (entradas == null) {
            throw new IllegalArgumentException("A lista não pode ser nula.");
        }
        mapaInterno = new HashMap<>();
        for (Entry<K, V> entrada : entradas) {
            if (entrada == null) continue;
            mapaInterno.put(entrada.getKey(), entrada.getValue());
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return mapaInterno.entrySet();
    }

    @Override
    public V put(K key, V value) {
        return mapaInterno.put(key, value);
    }

    @Override
    public V get(Object key) {
        return mapaInterno.get(key);
    }

    @Override
    public int size() {
        return mapaInterno.size();
    }
}
