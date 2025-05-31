import java.util.*;

public class MapParaList<K, V> extends AbstractList<V> {

    private Map<K, V> map;
    private List<K> keyOrder;

    public MapParaList(Map<K, V> map) {
        if (map == null) {
            throw new IllegalArgumentException("Mapa não pode ser nulo.");
        }
        this.map = map;
        this.keyOrder = new ArrayList<>(map.keySet());
    }

    @Override
    public V get(int index) {
        if (index < 0 || index >= keyOrder.size()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }
        K key = keyOrder.get(index);
        return map.get(key);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(V value) {
        K newKey = generateNewKey();
        map.put(newKey, value);
        keyOrder.add(newKey);
        return true;
    }

    @Override
    public V remove(int index) {
        if (index < 0 || index >= keyOrder.size()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }
        K key = keyOrder.remove(index);
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
        keyOrder.clear();
    }

    private K generateNewKey() {
        if (!keyOrder.isEmpty() && keyOrder.get(0) instanceof Integer) {
            int nextKey = 0;
            while (map.containsKey((K) Integer.valueOf(nextKey))) {
                nextKey++;
            }
            return (K) Integer.valueOf(nextKey);
        } else {
            throw new UnsupportedOperationException("Chave automática só é suportada para Integer.");
        }
    }


    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        if (map == null) throw new IllegalArgumentException("Mapa não pode ser nulo.");
        this.map = map;
        this.keyOrder = new ArrayList<>(map.keySet());
    }

    public List<K> getKeyOrder() {
        return keyOrder;
    }

    public void setKeyOrder(List<K> keyOrder) {
        if (keyOrder == null) throw new IllegalArgumentException("Lista de chaves não pode ser nula.");
        this.keyOrder = keyOrder;
    }
}
