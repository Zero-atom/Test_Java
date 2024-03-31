package Java_Core;
//Классы. Методы. Поля. Конструкторы. this, static, final
public class class2_4 {

}

//реализация Singleton
class DocumentHandler {

    private static DocumentHandler documentHandler;
    private String value;

    private DocumentHandler(String value) {

    }

    public static DocumentHandler getDocumentHandler(String value) {
        if (documentHandler == null) {
            documentHandler = new DocumentHandler(value);
        }
        return documentHandler;
    }
}

//перегрузка

class Human {

    private String firstName;
    private String lastName;
    private String email;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}

//class HumanCreate {
//    void create() {
//        Human firstPerson = new Human("Roger", "Brown");
//        Human secondPerson = new Human("Roger", "Brown", "rgr1337@gmail.com");
//    }
//}

//Ключевое слово this -- this всегда служит ссылкой на объект, для которого был вызван метод.
class Bicycle {

    // Поля
    private int cadence;
    private int gear;
    private int speed;

    // Конструктор
    public Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }

    // Методы
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    // Геттеры
}

class BicycleCreate {
    void create() {
        Bicycle myBike = new Bicycle(30, 0, 8);
    }
}

class Human1 {

    private String name;

    public Human1() {
        this("ANONYMOUS");
    }

    public Human1(String name) {
        this.name = name;
    }

    // Геттеры, Сеттеры
}

// Продемонстрировать статические переменные,
// методы и блоки кода
class UseStatic {
    static int а = 3;
    static int b;

    static void meth(int х) {
        System.out.println("x = " + х);
        System.out.println("a = " + а);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("Статический блок инициализирован.");
        b = а * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }
}

//final
