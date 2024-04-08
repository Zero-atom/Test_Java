package Java_Core.Module_6;
import java.util.function.Function;

public class LambdaExpression {
    //() -> 123.45
    //// Аналогично вызову следующего метода
    //douЫe myMeth() { return 123.45; }
    //
    //// Получим псевдослучайное число и умножим его на 100, вернем результат
    //() -> Math.random() * 100
    //
    //// Возвращает логическое значение true, если числовое значение параметра n оказывается четным
    //(n) -> (n % 2)==0
}

interface MyNumber {
    double getValue();
}

class LambdaDemo {
    public static void main(String args[]) {
        // создать ссылку на функциональный интерфейс MyNumЬer
        MyNumber myNum;

        // использовать лямбда-выражение в контексте присваивания
        myNum = () -> 123.45;

        // вызвать метод getValue(), реализуемый
        // присвоенным ранее лямбда-выражением
        System.out.println(myNum.getValue());
    }
}

interface NumericFunc {
    int func(int n);
}

class BlockLambdaDemo {
    public static void main(String args[]) {
        // Это блочное лямбда-выражение вычисляет
        // факториал целочисленного значения
        NumericFunc factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("Фaктopиaл числа 3 равен " + factorial.func(3));
        System.out.println("Фaктopиaл числа 5 равен " + factorial.func(5));
    }
}

interface StringFunc {
    String func(String n);
}

class LambdasAsArgumentsDemo {

    // Первый параметр этого метода имеет тип
    // функционального интерфейса. Следовательно, ему
    // можно передать ссылку на любой экземпляр этого
    // интерфейса, включая экземпляр, создаваемый в
    // лямбда-выражении. А второй параметр обозначает
    // обрабатываемую символьную строку
    static String stringOperation(StringFunc stringFunc, String s) {
        return stringFunc.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Java лучше всех!";
        String outStr;
        System.out.println("Этo исходная строка: " + inStr);

        // Ниже приведено простое лямбда-выражение,
        // преобразующее в прописные все буквы в исходной
        // строке, передаваемой методу stringOp()
        outStr = stringOperation((str) -> str.toUpperCase(), inStr);
        System.out.println("Этo строка прописными буквами: " + outStr);

        // А здесь передается блочное лямбда-выражение,
        // удаляющее пробелы из исходной символьной строки
        outStr = stringOperation((str) -> {
            String result = "";
            int i;
            for (i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            return result;
        }, inStr);

        System.out.println("Этo строка с удаленными пробелами: " + outStr);

        // Можно, конечно, передать и экземпляр
        // функционального интерфейса StringFunc,
        // созданный в предыдущем лямбда-выражении.
        // Например, после следующего объявления ссылка
        // reverse делается на экземпляр
        // интерфейса StringFunc
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        // А теперь ссылку reverse можно передать в
        // качестве первого параметра методУ stringOp(),
        // поскольку она делается на объект типа StringFunc
        System.out.println("Этo обращенная строка: " + stringOperation(reverse, inStr));
    }
}

//встроенный функциональный интерфейс Function
//import java.util.function.Function;

class BlockLambdaDemo1 {
    public static void main(String args[]) {

        // Это блочное лямбда-выражение вычисляет факториал
        // целочисленного значения. Для этой цели на сей раз
        // используется функциональный интерфейс Function
        Function<Integer, Integer> factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
//            (Integer i) -> i;
//
//            (int i) -> i++; return i;
//
//            ()-> return;
//
//            String a, String b -> System.out.print(a+ b);
        };
        System.out.println("Фaктopиaл числа 3 равен " + factorial.apply(3));
        System.out.println("Фaктopиaл числа 5 равен " + factorial.apply(5));
    }
}

