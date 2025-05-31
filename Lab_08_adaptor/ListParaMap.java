import java.util.*;

public class ListParaMap<K, V> extends AbstractMap<K, V> {

    private Map<K, V> internalMap;

    public ListParaMap(List<Map.Entry<K, V>> entryList) {
        if (entryList == null) {
            throw new IllegalArgumentException("Lista de entradas não pode ser nula.");
        }
        internalMap = new HashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            if (entry == null || entry.getKey() == null) {
                throw new IllegalArgumentException("Entradas e chaves não podem ser nulas.");
            }
            internalMap.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Chave não pode ser nula.");
        return internalMap.put(key, value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }

    // Gets e Sets

    public Map<K, V> getInternalMap() {
        return internalMap;
    }

    public void setInternalMap(Map<K, V> internalMap) {
        if (internalMap == null) throw new IllegalArgumentException("Mapa não pode ser nulo.");
        this.internalMap = internalMap;
    }
}
