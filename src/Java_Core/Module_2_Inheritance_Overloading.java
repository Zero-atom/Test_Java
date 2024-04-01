package Java_Core;

public class Module_2_Inheritance_Overloading {

    public static void main(String[] args) {
//        MountainBike bike = new MountainBike(1,3,4,5);
//        bike.setHeight(7);
//        System.out.println(bike.seatHeight);


    }
}

// Суперкласс
class Bicycle {
    public int cadence;
    public int gear;
    public int speed;

    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

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
}

class MountainBike extends Bicycle {

    public int seatHeight;

    public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    public void setHeight(int newValue) {
        this.seatHeight = newValue;
    }
}

//Переопределение методов
// Переопределение метода
class А {
    int i, j;

    А(int а, int b) {
        i = а;
        j = b;
    }

    // вывести содержимое переменных i и j
    void show() {
        System.out.println("i и j: " + i + " " + j);
    }
}

class В extends А {
    int k;

    В(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    void show() {
        super.show(); // здесь вызывается метод show() из класса А
        System.out.println("k: " + k);
    }
}

class Overload {
    public static void main(String[] args) {
        В subOb = new В(1, 2, 3);
        subOb.show();
    }
}

//перегрузка
// Перегрузка метода
class A2 {
    int i, j;

    A2(int а, int b) {
        i = а;
        j = b;
    }

    // вывести содержимое переменных i и j
    void show() {
        System.out.println("i и j: " + i + " " + j);
    }
}

class В2 extends A2 {
    int k;

    В2(int а, int b, int с) {
        super(а, b);
        k = с;
    }

    void show(String message) {
        System.out.println(message + " k: " + k);
        super.show(); // здесь вызывается метод show() из класса А
    }
}

class OverrideDemo {
    public static void main(String args[]) {
        В2 subOb = new В2(1, 2, 3);
        subOb.show("Значение");
    }
}