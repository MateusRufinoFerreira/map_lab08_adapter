import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Map<Integer, String> mapaOriginal = new HashMap<>();
            mapaOriginal.put(0, "A");
            mapaOriginal.put(1, "B");
            mapaOriginal.put(2, "C");

            List<String> listaAdaptada = new MapParaList<>(mapaOriginal);
            listaAdaptada.add("D");

            System.out.println("Map adaptado como List:");
            for (String valor : listaAdaptada) {
                System.out.println(" - " + valor);
            }

            List<Map.Entry<String, Integer>> entradas = new ArrayList<>();
            entradas.add(new AbstractMap.SimpleEntry<>("um", 1));
            entradas.add(new AbstractMap.SimpleEntry<>("dois", 2));

            Map<String, Integer> mapaAdaptado = new ListParaMap<>(entradas);
            mapaAdaptado.put("três", 3);

            System.out.println("List adaptado como Map:");
            for (Map.Entry<String, Integer> entrada : mapaAdaptado.entrySet()) {
                System.out.println(" - " + entrada.getKey() + " = " + entrada.getValue());
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar o programa: " + e.getMessage());
        }
    }
}
