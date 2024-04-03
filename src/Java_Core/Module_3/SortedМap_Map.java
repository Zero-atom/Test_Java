package Java_Core.Module_3;

//для map
import java.util.*;

public class SortedМap_Map {
}


//HashMap
class HashMapDemo {
    public static void main(String args[]) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Superman");
        hashMap.put(2, "Batman");
        hashMap.put(3, "Ironman");
        System.out.println("Initial list of elements:");
        printMap(hashMap);

        System.out.println("Updated list of elements:");
        hashMap.replace(2, "Batman", "Spiderman");
        printMap(hashMap);

        String hero = hashMap.getOrDefault(42, "Flash");
        System.out.println("Default value for absent entry:\n" + hero);
    }

    private static void printMap(Map<Integer, String> map) {
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

}

///Класс TreeMap
//import java.util.*;

class TreeMapDemo {
    public static void main(String args[]) {
// создать древовидное отображение
        Map<String, Double> tm = new TreeMap<>();
        // ввести элементы в древовидное отображение
        tm.put("Rodger Rabbit", 3434.34);
        tm.put("Sara Connor", 123.22);
        tm.put("Jack Black", 99.22);
        tm.put("Sad Ralf", -19.08);

        // получить множество записей
        Set<Map.Entry<String, Double>> set = tm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();
        // внести сумму 1000 на счет Sad Ralf
        double balance = tm.get("Sad Ralf");
        tm.put("Sad Ralf", balance + 1000);
        System.out.println("Hoвый остаток на счете Sad Ralf: " + tm.get("Sad Ralf"));
    }
}


//import java.util.*;

class EnumMapDemo {
    enum Color {
        RED, GREEN, BLUE, WHITE
    }

    public static void main(String[] args) {
        // Creating an EnumMap of the Color enum
        EnumMap<Color, Integer> colors1 = new EnumMap<>(Color.class);

        // Insert using put() method
        colors1.put(Color.RED, 1);
        colors1.put(Color.GREEN, 2);

        // print mappings to the console
        System.out.println("EnumMap colors1: " + colors1);

        // Creating an EnumMap of the Color Enum
        EnumMap<Color, Integer> colors2 = new EnumMap<>(Color.class);

        // Add using the putAll() Method
        colors2.putAll(colors1);
        colors2.put(Color.BLUE, 3);

        // print mappings to the console
        System.out.println("EnumMap colors2: " + colors2);
    }
}


