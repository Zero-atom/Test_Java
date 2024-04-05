package Java_Core.Module_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Streams {
}


class StreamsDemo {
    public static void main(String args[]) {
        List<Integer> myList = List.of(7, 18, 10, 24, 17, 5);
        System.out.println("Иcxoдный список: " + myList);

        // получить поток элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        // получить минимальное и максимальное значения,
        // вызвав методы min(), max(), isPresent() и get()
        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) {
            System.out.println("Минимальное значение: " + minVal.get());
        }

        // получить новый поток данных,
        // поскольку предыдущий вызов метода min()
        // стал оконечной операцией, употребившей поток данных
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) {
            System.out.println("Максимальное значение: " + maxVal.get());
        }
        // отсортировать поток данных, вызвав метод sorted()
        Stream<Integer> sortedStream = myList.stream().sorted();

        // отобразить отсортированный поток данных,
        // вызвав метод forEach()
        System.out.print("Oтcopтиpoвaнный поток данных: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // вывести только нечетные целочисленные значения,
        // вызвав метод filter()
        Stream<Integer> oddVals = myList
                .stream()
                .sorted()
                .filter((n) -> (n % 2) == 1);
        System.out.print("Heчeтныe значения: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // вывести только те нечетные целочисленные
        // значения, которые больше 5. Обратите внимание
        // на конвейеризацию обеих операций фильтрации
        oddVals = myList
                .stream()
                .filter((n) -> (n % 2) == 1)
                .filter((n) -> n > 5);
        System.out.print("Heчeтныe значения больше 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}

class StreamsDemo1 {
    public static void main(String args[]) {
        List<Integer> myList = List.of(7, 18, 10, 24, 17, 5);

        // Два способа получения результата перемножения
        // целочисленных элементов списка myList с помощью
        // метода reduce()
        Optional<Integer> productOptional = myList.stream().reduce((a, b) -> a * b);
        if (productOptional.isPresent()) {
            System.out.println("Пpoизвeдeниe в виде объекта Optional: " + productOptional.get());
        }

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Пpoизвeдeниe в виде значения типа int: " + product);
    }
}