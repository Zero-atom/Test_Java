package Java_Core;

public class Module_2_Packages_Interfaces {
}

//вложенный интерфейс

// Пример вложенного интерфейса
// Этот класс содержит интерфейс как свой член
class A {
    // это вложенный интерфейс
    public interface NestedIF {
        boolean isNotNegative(int х);
    }
}

// Класс В3 реализует вложенный интерфейс
class В3 implements A.NestedIF {
    public boolean isNotNegative(int х) {
        return х >= 0;
    }
}

class NestedIFDemo {
    public static void main(String args[]) {
        // использовать ссылку на вложенный интерфейс
        A.NestedIF nif = new В3();

        if (nif.isNotNegative(10)) {
            System.out.println("Чиcлo 10 неотрицательное");
        }

        if (nif.isNotNegative(-12)) {
            System.out.println("Этo не будет выведено");
        }
    }
}

//Методы с реализацией по умолчанию
interface MyIF {
    // Это объявление обычного метода в интерфейсе.
    // Он НЕ предоставляет реализацию по умолчанию
    int getNumЬer();

    // А это объявление метода с реализацией по умолчанию.
    // Обратите внимание на его реализацию по умолчанию
    default String getString () {
        return "Объект типа String по умолчанию";
    }
}

//Закрытые методы интерфейсов
interface IntStack {
    void push(int item); // сохранить элемент в стеке
    int рор(); // извлечь элемент из стека

    // Метод с реализацией по умолчанию, возвращающий
    // массив из n элементов, начиная с вершины стека
    default int[] popNElements(int n) {
        // возвратить запрашиваемые элементы из стека
        return getElements(n);
    }

    // Метод с реализацией по умолчанию, возвращающий
    // из стека массив из n элементов, следующих после
    //указанного количества пропускаемых элементов
    default int[] skipAndPopNElements(int skip, int n) {
        // пропустить указанное количество элементов в стеке
        getElements(skip);
        // возвратить запрашиваемые элементы из стека
        return getElements(n);
    }

    // Закрытый метод, возвращающий массив из n элементов,
    // начиная с вершины стека
    private int[] getElements(int n) {
        int[] elements = new int[n];
        for (int i=0; i < n; i++) elements[i] = рор();
        return elements;
    }
}