package Java_Core.Module_2;

public class Module_2_Generalizations {
    void main(String[] args) {
        //Создадим объект класса Box:
        Box1<Integer> integerBox = new Box1<>();
    }
}

//Простой пример обобщения

class Box1<T> {
    // T обозначает "Тип"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}

//Обобщения оперируют только ссылочными типами
//Box<int> box = new Box<int>(53); // ОШИБКА! Использовать примитивные типы нельзя!

//Ограниченные типы
class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    // Параметр U может быть заменен только указанным суперклассом Number или его подклассами
    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(10);
        System.out.println(integerBox.get());
        //integerBox.inspect(10);
        //integerBox.inspect("some text"); // ОШИБКА!
    }
}

//ограничение может включать в себя как тип класса, так и типы одного или нескольких интерфейсов:
//class Example<T extends MyClass & Myinterface> { // ...

//верхняя граница
//<? extends суперкласс>

//нижняя
//<? super подкласс>
