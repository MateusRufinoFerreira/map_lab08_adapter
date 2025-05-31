import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Map<Integer, String> map = new HashMap<>();
            map.put(0, "A");
            map.put(1, "B");
            map.put(2, "C");

            List<String> adaptedList = new MapParaList<>(map);
            adaptedList.add("D");
            System.out.println("Map adaptado como List:");
            for (String s : adaptedList) {
                System.out.println(" - " + s);
            }

            List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
            entryList.add(new AbstractMap.SimpleEntry<>("one", 1));
            entryList.add(new AbstractMap.SimpleEntry<>("two", 2));

            Map<String, Integer> adaptedMap = new ListParaMap<>(entryList);
            adaptedMap.put("three", 3);

            System.out.println("\nList adaptado como Map:");
            for (Map.Entry<String, Integer> entry : adaptedMap.entrySet()) {
                System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
            }

        } catch (Exception e) {
            System.err.println("Erro ao executar o programa: " + e.getMessage());
        }
    }
}
