package Java_Core.Module_2;
import java.math.BigDecimal;

public class Module_2_types {

}


class DynInit {
    public static void main(String args[]) {
        //Переменная определяется в виде сочетания идентификатора, типа и необязательного начального значения.
        double а = 3.0, b = 4.0;
        // динамическая инициализация переменной с
        double с = Math.sqrt(а * а + b * b);
        System.out.println("Гипoтeнyзa равна " + с);
    }
}

//Область видимости и срок действия переменных
//блок кода задает область видимости
// Продемонстрировать область видимости блока кода
class Scope {
    public static void main(String args[]) {
        int х; // эта переменная доступна всему
        // коду из метода main()
        х = 10;
        if (х == 10) { // начало новой области действия,
            int у = 20; //доступной только этому блоку кода
            // обе переменные х и у доступны в
            // этой области действия
            System.out.println("x и у: " + х + " " + у);
            х = у * 2;
        }
        //y = 100; //ОШИБКА! переменная у недоступна
        // в этой области действия, тогда как
        // переменная х доступна и здесь
        System.out.println("x равно " + х);
    }
}

//Преобразование и приведение типов
//автоматическое преобразование типов если совместимы int ->  long
//не совметсимы типа doublе в тип bуtе (byte выделяет меньше памяти и число про урежится )

class Conversion {
    public static void main(String args[]) {
        byte b;
        int i = 257;
        double d = 323.999;

        System.out.println("\nПреобразование типа int в тип byte."); // если перевести в двоичный формат будет понятнее 257 = 100000001 и при переводе урежится до 1 (т к токо 7 бит под значение)
        b = (byte) i;
        System.out.println("i и b " + i + " " + b);

        System.out.println("\nПреобразование типа double в тип int.");// просто отбрасывается дробная часть даже если 0.9999 = 0
        i = (int) d;
        System.out.println("d и i " + d + " " + i);

        System.out.println("\nПреобразование типа double в тип byte.");//аналогично 1 и 2 примеру
        b = (byte) d;
        System.out.println("d и b " + d + " " + b);
    }
}

//виды типов
//Примитивные типы - четыре группы: целые числа, числа с плавающей точкой, символы, логические значения.

//Целые числа - byte (8 бит) , short (16 бит) , int (32 бит ) и long (64 бит) - представляющие целые числа со знаком. (первый бит под знак (- -> 1) (0 -> +))
class Light {
    public static void main(String args[]) {
        int lightspeed;
        long days;
        long seconds;
        long distance;

        lightspeed = 186000; // приблизительная скорость света, миль в секунду
        days = 1000;         // указать количество дней
        seconds = days * 24 * 60 * 60;     // преобразовать в секунды
        distance = lightspeed * seconds;   // вычислить расстояние

        System.out.print("Зa " + days);
        System.out.print(" дней свет пройдет около ");
        System.out.println(distance + " миль.");
    }
}

//Числа с плавающей точкой - float (32 бит) и double (64 бит)
// Вычислить площадь круга
class Area {
    public static void main(String args[]) {
        double radius = 10.8;                   // радиус окружности
        double pi = Math.PI;                    // приблизительное значение числа пи
        double area = pi * Math.pow(radius, 2); // вычислить площадь круга

        System.out.println("Площадь круга равна " + area);
    }
}

//Символы
//символы представлены в Юникоде
class CharDemo {
    public static void main(String args[]) {
        char chl, ch2;
        chl = 88; // код символа Х
        ch2 = 'у';
        System.out.print("chl и ch2: ");
        System.out.println(chl + " " + ch2);
    }
}

//Логические значения
//boolean
class BoolTest {
    public static void main(String args[]) {
        boolean b;

        b = false;
        System.out.println("b равно " + b);
        b = true;
        System.out.println("b равно " + b);

        if (b) System.out.println("Этoт код выполняется.");
        b = false;
        if (b) System.out.println("Этoт код не выполняется.");

        System.out.println("10 > 9 равно " + (10 > 9));
    }
}

//Float point error
//неточности при работе с числами
class Account {
    private double moneyAmount;
    private Long userId;

    // constructors, getters and setters

    // Constructor
    public Account(double moneyAmount, Long userId) {
        this.moneyAmount = moneyAmount;
        this.userId = userId;
    }

    // Getters
    public double getMoneyAmount() {
        return moneyAmount;
    }

    public Long getUserId() {
        return userId;
    }

    // Setters
    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double addMoney(double receive) {
        moneyAmount += receive;
        return moneyAmount;
    }
}

class Application {
    public static void main(String[] args) {
        Account account = new Account(0.1, 1L);
        double accountMoney = account.addMoney(0.2);
        System.out.println("Денег на счету: " + accountMoney);

        accountMoney = account.addMoney(0.4);
        System.out.println("Money after adding: $" + accountMoney);

        accountMoney = account.addMoney(0.9);
        System.out.println("Money after adding: $" + accountMoney);
    }
}
// если важна точность вычисления чисел с плавающей точкой, то использование типов float и double категорически запрещено.

//исправленный  с BigDecimal
//import java.math.BigDecimal;
class BDAccount {

    private BigDecimal moneyAmount;
    private Long userId;

    // constructors, getters and setters
    // Constructor
    public BDAccount(BigDecimal moneyAmount, Long userId) {
        this.moneyAmount = moneyAmount;
        this.userId = userId;
    }

    public BigDecimal addMoney(BigDecimal receive) {
        moneyAmount = moneyAmount.add(receive);
        return moneyAmount;
    }

}

class BigDecimalApplication {
    public static void main(String[] args) {
        BDAccount account = new BDAccount(new BigDecimal("0.1"), 1L);
        BigDecimal receive = new BigDecimal("0.2");
        BigDecimal accountMoney = account.addMoney(receive);
        System.out.println("Денег на счету: " + accountMoney);
    }
}


