package Java_Core.Module_2;

public class Enum {
}

enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

    private int price; // Цена яблока каждого сорта

    // Конструктор
    Apple(int р) {
        price = р;
    }

    int getPrice() {
        return price;
    }
}

class EnumDemo {
    public static void main(String[] args) {
        System.out.println("Яблoкo сорта Winesap стоит " + Apple.Winesap.getPrice() + " центов. \n");
        // Вывести цены на все сорта яблок
        System.out.println("Цeны на все сорта яблок:");
        for (Apple a : Apple.values())
            System.out.println(a + " стоит " + a.getPrice() + " центов.");
    }
}
