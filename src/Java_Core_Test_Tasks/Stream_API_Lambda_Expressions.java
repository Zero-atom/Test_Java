package Java_Core_Test_Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_API_Lambda_Expressions {
    public static void main(String[] args) {

        //создаем двигатели
        Engine engine1 = new Engine("V6");
        Engine engine2 = new Engine("Inline-4");
        Engine engine3 = new Engine("V8");
        Engine engine4 = new Engine("Inline-4");

        //создаем колеса
        Wheel[] wheels1 = {new Wheel("Michelin"), new Wheel("Michelin"), new Wheel("Michelin"), new Wheel("Michelin")};
        Wheel[] wheels2 = {new Wheel("Bridgestone"), new Wheel("Bridgestone"), new Wheel("Bridgestone"), new Wheel("Bridgestone")};
        Wheel[] wheels3 = {new Wheel("Pirelli"), new Wheel("Pirelli"), new Wheel("Pirelli"), new Wheel("Pirelli")};
        Wheel[] wheels4 = {new Wheel("Goodyear"), new Wheel("Goodyear"), new Wheel("Goodyear"), new Wheel("Goodyear")};

        // Создаем коллекцию из объектов Car
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2019, engine1, wheels1));
        cars.add(new Car("Honda", "Civic", 2020, engine2, wheels2));
        cars.add(new Car("Ford", "Mustang", 2018, engine3, wheels3));
        cars.add(new Car("Chevrolet", "Cruze", 2017, engine4, wheels4));

        //тестируем машины
//        for (Car car : cars) {
//            System.out.println(car);
//            car.drive();
//        }

        // Выводим исходную коллекцию
        System.out.println("Исходная коллекция:");
        cars.forEach(System.out::println);

        // Удаляем элементы из коллекции с помощью Stream API
        List<String> brandsToRemove = List.of("Ford", "Chevrolet");
        cars = cars.stream()
                .filter(car -> !brandsToRemove.contains(car.getBrand()))
                .collect(Collectors.toList());

        // Выводим измененную коллекцию
        System.out.println("\nКоллекция после удаления:");
        cars.forEach(System.out::println);
//        List<String> list = new ArrayList<String>();
//        list.add("One");
//        list.add("Two");
//        list.add("Three");
//        list.add("Four");
//        list.add("Five");
//        list.add("Six");
//        list.add("Seven");
//        list.add("Eight");
//        list.add("Nine");
//        list.add("Ten");
//        Stream stream = list.stream();

        //с потоком
        //IntStream.of(50, 60, 70, 80, 90, 100, 110, 120).filter(x -> x < 90).map(x -> x + 10).limit(3).forEach(System.out::print);
        //list.stream().filter(x -> x.length()<4).map(x -> x + "ХАУНД").limit(5).forEach(System.out::println);

        //без потока
//        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
//        int count = 0;
//        for (int x : arr) {
//            if (x >= 90) continue;
//            x += 10;
//            count++;
//            if (count > 3) break;
//            System.out.print(x);
//        }
    }
}

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void drive() {
        System.out.println("Двигатель работает");
    }
}

class Wheel {
    private String brand;

    public Wheel(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void drive() {
        System.out.println("колеса едут");
    }
}

class Car {
    private String brand;
    private String model;
    private int year;

    private Engine engine;
    private Wheel[] wheels;

    public Car(String brand, String model, int year, Engine engine, Wheel[] wheels) {
        this.brand = brand;
        this.model = model;
        this.year = year;

        //композиция
        this.engine = engine;
        this.wheels = wheels;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engine=" + engine.getType() +
                ", wheels=" + Arrays.toString(wheels) +
                '}';
    }

    //делегирование
    public void drive() {
        this.engine.drive();
        for (int i =0 ;i < this.wheels.length; i++) {
            this.wheels[i].drive();
        }
    }
}


