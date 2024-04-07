package Java_Core_Test_Tasks;

import java.util.function.Consumer;

public class Exception_Lambda_Expressions {
}

class Main {
    public static void main(String[] args) {
        // Вызов метода, бросающего checked exception, в лямбда-выражении
        Consumer<String> consumerWithCheckedException = str -> {
            try {
                methodThrowingCheckedException(str);
            } catch (Exception e) {
                System.err.println("Caught checked exception: " + e.getMessage());
            }
        };

        // Вызов метода, бросающего unchecked exception, в лямбда-выражении
        Consumer<String> consumerWithUncheckedException = str -> {
            throwUncheckedException(str);
        };

        // Пример использования лямбда-выражений
        consumerWithCheckedException.accept("Test"); // Вызов метода с checked exception
        consumerWithUncheckedException.accept("Test"); // Вызов метода с unchecked exception
    }

    // Метод, бросающий checked exception
    public static void methodThrowingCheckedException(String str) throws Exception {
        if (str.equals("Test")) {
            throw new Exception("Checked exception occurred!");
        } else {
            System.out.println("No exception occurred.");
        }
    }

    // Метод, бросающий unchecked exception
    public static void throwUncheckedException(String str) {
        if (str.equals("Test")) {
            throw new RuntimeException("Unchecked exception occurred!");
        } else {
            System.out.println("No exception occurred.");
        }
    }
}

//Checked исключения:
interface MyInterface {
    void myMethod() throws Exception;//объявить, что метод выбрасывает исключение
}

class Main1 {
    public static void main(String[] args) {
        MyInterface myInterface = () -> {
            // Необходимо обработать исключение или объявить, что метод выбрасывает исключение
            // Иначе будет ошибка компиляции
            //throw new Exception("Checked exception");

        };
        //myInterface.myMethod ();
    }
}

//Unchecked исключения:
interface MyInterface2 {
    void myMethod();
}

class Main2 {
    public static void main(String[] args) {
        MyInterface2 myInterface = () -> {
            // Unchecked исключения могут быть выброшены без объявления
            throw new RuntimeException("Unchecked exception");
        };
    }
}

// Генерирование исключений в лямбда-выражениях
// Объявить функциональный интерфейс
interface IDivNumbers {
    // Объявить метод, который делит два числа
    double Division(double a, double b);
}

// Класс, который содержит методы, реализующие лямбда-выражения и
// тестируют работу программы.
class Lambda {

    public static void main(String[] args) {

        // 1. Объявить ссылку на IDivNumbers
        IDivNumbers ref;

        // 2. Реализовать лямбда-выражение, которое делит два числа и
        //    при необходимости генерирует исключение
        ref = (a, b) -> {
            try {
                // Обработать проверку деления на 0
                if (b==0)
                    throw new ArithmeticException("Exception: divide by zero.");
                return a/b; // если b!=0, то вернуть результат деления
            }
            catch (ArithmeticException e) {
                System.out.println(e.getMessage()); // Вывести сообщение
                return 0.0;
            }
        };

        // 3. Протестировать лямбда-выражение на исключительную ситуацию
        double res = ref.Division(5, 0); // Exception: divide by zero.

        // 4. Вывести результат
        System.out.println("res = " + res); // res = 0.0
    }
}

