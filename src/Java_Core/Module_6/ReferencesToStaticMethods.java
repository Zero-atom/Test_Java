package Java_Core.Module_6;

public class ReferencesToStaticMethods {
}

interface StringFunc1 {
    String func(String n);
}

//В этом классе определяется статический
//метод strReverse()
class MyStringOps {

    //Статический метод, изменяющий порядок
    // следования символов в строке
    static String strReverse(String str) {
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }
}

class MethodRefDemo {

    // В этом методе функциональный интерфейс
    // указывается в качестве типа первого его
    // параметра. Следовательно, ему может быть
    // передан любой экземпляр данного интерфейса,
    // включая и ссылку на метод
    static String stringOperation(StringFunc1 sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "На лучшем языке писать имеешь право!";
        String outStr;
        // Здесь ссылка на метод strReverse() передается
        // методу stringOperation()
        outStr = stringOperation(MyStringOps::strReverse, inStr);
        System.out.println("Иcxoднaя строка: " + inStr);
        System.out.println("Oбpaщeннaя строка: " + outStr);
    }
}
