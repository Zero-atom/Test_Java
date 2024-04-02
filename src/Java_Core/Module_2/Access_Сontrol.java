package Java_Core.Module_2;
//классы находятся в одном пакете
public class Access_Сontrol {
}

class Test {
    int а; // доступ, определяемый по умолчанию (доступен в пределах пакета)
    public int Ь; // открытый доступ
    private int с; // закрытый доступ

    // методы доступа к члену с данного класса
    void setc(int i) {
        //установить значение члена с данного класса
        с = -i;
    }

    int getc() {
        //получить значение члена с данного класса
        return с;
    }
}

class AccessTest {
    public static void main(String args[]) {
        Test ob = new Test();

        //Эти операторы правильны, поэтому члены а и Ь
        //данного класса доступны непосредственно
        ob.а = 10;
        ob.Ь = 20;

        // Этот оператор неверен и может вызвать ошибку
        // ob.с = 100; //ОШИБКА!

        //Доступ к члену с данного класса должен
        // осуществляться с помощью методов его класса
        ob.setc(100); //ВЕРНО!
        System.out.println("a, Ь, и с: " + ob.а + " " + ob.Ь + " " + ob.getc());
    }
}

//вложенные классы
// Продемонстрировать применение внутреннего класса
class Outer {
    int outerX = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // это внутренний класс
    class Inner {
        void display() {
            System.out.println("Вывoд: outerX = " + outerX);
        }
    }
}

class InnerClassDemo {
    public static void main(String args[]) {
        Outer outer = new Outer();
        outer.test();
    }
}
