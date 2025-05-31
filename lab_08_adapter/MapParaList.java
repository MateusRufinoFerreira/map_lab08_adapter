import java.util.*;

public class MapParaList<K, V> extends AbstractList<V> {
    private final Map<K, V> map;
    private final List<K> chaves;

    public MapParaList(Map<K, V> map) {
        if (map == null) {
            throw new IllegalArgumentException("O mapa não pode ser nulo.");
        }
        this.map = map;
        this.chaves = new ArrayList<>(map.keySet());
    }

    @Override
    public V get(int index) {
        validarIndice(index);
        return map.get(chaves.get(index));
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(V value) {
        int novaChave = map.size();
        while (map.containsKey((K) Integer.valueOf(novaChave))) {
            novaChave++;
        }
        map.put((K) Integer.valueOf(novaChave), value);
        chaves.add((K) Integer.valueOf(novaChave));
        return true;
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
    }
}
